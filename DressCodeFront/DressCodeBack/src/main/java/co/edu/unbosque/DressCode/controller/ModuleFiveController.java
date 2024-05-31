package co.edu.unbosque.DressCode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.DressCode.model.Amortization;
import co.edu.unbosque.DressCode.model.Credit;
import co.edu.unbosque.DressCode.model.Customer;
import co.edu.unbosque.DressCode.model.Parameter;
import co.edu.unbosque.DressCode.model.Product;
import co.edu.unbosque.DressCode.model.PurchaseDetail;
import co.edu.unbosque.DressCode.model.Sale;
import co.edu.unbosque.DressCode.model.SaleDetail;
import co.edu.unbosque.DressCode.repository.AmortizationRepository;
import co.edu.unbosque.DressCode.repository.CreditRepository;
import co.edu.unbosque.DressCode.repository.CustomerRepository;
import co.edu.unbosque.DressCode.repository.ParameterRepository;
import co.edu.unbosque.DressCode.repository.ProductRepository;
import co.edu.unbosque.DressCode.repository.SaleDetailRepository;
import co.edu.unbosque.DressCode.repository.SaleRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class ModuleFiveController {
	@Autowired
	private ProductRepository prrep;
	@Autowired
	private CustomerRepository crep;
	@Autowired
	private SaleRepository srep;
	@Autowired
	private SaleDetailRepository sdrep;
	@Autowired
	private ParameterRepository parep;
	@Autowired
	private AmortizationRepository arep;
	@Autowired
	private CreditRepository crerep;
	
	
	//boton de buscar cliente
	@PostMapping("/customer")
	public Customer findCustomerByDocument(@RequestBody Customer cu) {
		return crep.findByDocument(cu.getDocument());
	}
	
	//boton de buscar producto
	@PostMapping("/product")
	public Optional<Product> findProductById(@RequestBody Product pr){
		return prrep.findById(pr.getId_product());
	}
	
	//boton de agregar al carrito
	@PostMapping("/saledetail/new")
	public ResponseEntity<String> addSaleDetail(@RequestBody SaleDetail sd){
		Product p = prrep.findById(sd.getId_product()).get();		
		
		SaleDetail temp = new SaleDetail(sd.getCustomer_doc(), sd.getId_product(), Integer.parseInt((srep.count()+1)+""), sd.getQuantity(), p.getSales_price(), p.getSales_price()*sd.getQuantity());
		
		sdrep.save(temp);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Registrado con Exito");
	}
	
	//la pagina de finalizar compra
	@GetMapping("/saledetail/all")
	public ResponseEntity<List<SaleDetail>> showSaleDetail(){
		List<SaleDetail> listTotal = (List<SaleDetail>) sdrep.findAll();
		
		if (listTotal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listTotal);
	}
	
	//la pagina de finalizar compra
	@GetMapping("/saledetail")
	public ResponseEntity<List<SaleDetail>> showSaleDetailById(){
		List<SaleDetail> listTotal = (List<SaleDetail>) sdrep.findAll();
		List<SaleDetail> temp = new ArrayList<>();
		
		for(int i = 0; i<listTotal.size(); i++) {
			if(listTotal.get(i).getId_sale().equals(Integer.parseInt((srep.count()+1)+""))) {
				temp.add(listTotal.get(i));
			}
		}
		
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	//pagar en efectivo
	@PostMapping("/sale/new")
	public ResponseEntity<String> addSale(){
		List<SaleDetail> listTotal = (List<SaleDetail>) sdrep.findAll();
		List<SaleDetail> l = new ArrayList<>();
		
		for(int i = 0; i<listTotal.size(); i++) {
			if(listTotal.get(i).getId_sale().equals(Integer.parseInt((srep.count()+1)+""))) {
				l.add(listTotal.get(i));
			}
		}
		
		Parameter par = parep.findAll().get(0);
		
		float total = 0;
		
		for (int i = 0; i < l.size(); i++) {
			total += l.get(i).getTotal_value();
		}
		
		Sale temp = new Sale(l.get(0).getCustomer_doc(), total, par.getIva(), total+(total*par.getIva()));
		
		srep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Venta generada con exito");
	}
	
	//Mostrar Total
	@GetMapping("/sale")
	public ResponseEntity<List<Sale>> showSale(){
		
		List<Sale> listTotal = (List<Sale>) srep.findAll();
		List<Sale> temp = new ArrayList<>();
		
		for(int i = 0; i<listTotal.size(); i++) {
			if(listTotal.get(i).getId_sale().equals(Integer.parseInt((srep.count())+""))) {
				temp.add(listTotal.get(i));
			}
		}
		
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	//Boton calcular
	@PostMapping("/amortization/new")
	public ResponseEntity<String> payToQuotes(@RequestBody Amortization am) {
		List<SaleDetail> listTotal = (List<SaleDetail>) sdrep.findAll();
		List<SaleDetail> l = new ArrayList<>();
		
		for(int i = 0; i<listTotal.size(); i++) {
			if(listTotal.get(i).getId_sale().equals(Integer.parseInt((srep.count())+""))) {
				l.add(listTotal.get(i));
			}
		}
		Parameter par = parep.findAll().get(0);
		
		float total = srep.findById(Integer.parseInt((srep.count())  +"")).get().getTotal_iva();
		
		float quota_val = (total + total*par.getInterest_rate())/am.getQuota_number();
		
		Amortization tempa = new Amortization(Integer.parseInt((crerep.count()+1)+""), am.getQuota_number(), total, quota_val, par.getInterest_rate(), total/(am.getQuota_number()/12));
		
		arep.save(tempa);
		
		Credit c = new Credit(Integer.parseInt(arep.count()+""), Integer.parseInt(srep.count()+""), l.get(0).getCustomer_doc(), 1, total, quota_val, par.getInterest_rate(), tempa.getAmortization());
		
		crerep.save(c);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Tabla de amortizacion generada con exito");
	}
	
	//Ver amortizacion
	@GetMapping("/amortization")
	public ResponseEntity<List<Amortization>> showAmortization(){
		List<Amortization> listTotal = (List<Amortization>) arep.findAll();
		List<Amortization> temp = new ArrayList<>();
		
		for(int i = 0; i<listTotal.size(); i++) {
			if(listTotal.get(i).getId_amortization().equals(Integer.parseInt((arep.count())+""))) {
				temp.add(listTotal.get(i));
			}
		}
		
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	//boton calcular
	public void buttonCalculate(@RequestBody Amortization am) {
		payToQuotes(am);
		showAmortization();
	}
	
}

