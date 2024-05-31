package co.edu.unbosque.DressCode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.DressCode.model.Check;
import co.edu.unbosque.DressCode.model.Parameter;
import co.edu.unbosque.DressCode.model.Product;
import co.edu.unbosque.DressCode.model.Purchase;
import co.edu.unbosque.DressCode.model.PurchaseDetail;
import co.edu.unbosque.DressCode.model.Supplier;
import co.edu.unbosque.DressCode.repository.CheckRepository;
import co.edu.unbosque.DressCode.repository.ParameterRepository;
import co.edu.unbosque.DressCode.repository.ProductRepository;
import co.edu.unbosque.DressCode.repository.PurchaseDetailRepository;
import co.edu.unbosque.DressCode.repository.PurchaseRepository;
import co.edu.unbosque.DressCode.repository.SupplierRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class ModuleSixController {
	@Autowired
	private ProductRepository prep;
	@Autowired
	private SupplierRepository srep;
	@Autowired
	private PurchaseRepository purep;
	@Autowired
	private PurchaseDetailRepository pdrep;
	@Autowired
	private CheckRepository chrep;
	@Autowired
	private ParameterRepository parrep;
	private String nit;

	// boton de buscar proveedor
	@PostMapping("/supplier/{nit}")
	public Supplier findSupplierByNit(@RequestBody Supplier sp) {
		List<Supplier> l = srep.findAll();

		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getNit().equals(sp.getNit())) {
				return l.get(i);
			}
		}

		return null;
	}

	// boton de buscar producto USAR EL DEL MODULO 5!!!!!!

	// boton de agregar al carrito
	@PostMapping("/purchasedetail/new")
	public ResponseEntity<String> addPurchaseDetail(@RequestBody PurchaseDetail pd) {
		Product p = prep.findById(pd.getId_product()).get();

		PurchaseDetail temp = new PurchaseDetail(pd.getId_product(), Integer.parseInt(purep.count() + ""), pd.getQuantity(),
				p.getSales_price()*pd.getQuantity());

		pdrep.save(temp);

		return ResponseEntity.status(HttpStatus.CREATED).body("Registrado con Exito");
	}

	// finalizar compra xd
	public String goToPurchase(String document) {

		return "nombre de la pagina";
	}

	// pagar en efectivo
	@PostMapping("/purchase/new")
	public ResponseEntity<String> addPurchase() {
		List<PurchaseDetail> listTotal = (List<PurchaseDetail>) pdrep.findAll();
		List<PurchaseDetail> l = new ArrayList<>();

		for (int i = 0; i < listTotal.size(); i++) {
			if (listTotal.get(i).getId_purchase().equals(Integer.parseInt(srep.count() + ""))) {
				l.add(listTotal.get(i));
			}
		}

		Parameter par = parrep.findAll().get(0);

		float total = 0;

		for (int i = 0; i < l.size(); i++) {
			total += l.get(i).getTotal_value();
		}

		
		Purchase temp = new Purchase(nit, total, par.getIva(), total + (total * par.getIva()));

		purep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Venta generada con exito");
	}

	// la pagina de finalizar compra
	@GetMapping("/purchasedetail")
	public ResponseEntity<List<PurchaseDetail>> showPurchaseDetailById() {
		List<PurchaseDetail> listTotal = (List<PurchaseDetail>) pdrep.findAll();
		List<PurchaseDetail> temp = new ArrayList<>();

		for (int i = 0; i < listTotal.size(); i++) {
			if (listTotal.get(i).getId_purchase().equals(Integer.parseInt(purep.count() + ""))) {
				temp.add(listTotal.get(i));
			}
		}

		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}

	// Crear un nuevo cheque
	@PostMapping("/checktable/new")
	public ResponseEntity<String> addNewCheck() {
		Purchase pu = purep.findById(Integer.parseInt(purep.count() + "")).get();

		Check temp = new Check(Integer.parseInt(purep.count() + ""), this.nit, pu.getTotal_iva());

		chrep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Cheque Registrado con Exito");
	}

	// Sacar el cheque
	@GetMapping("/checktable/last")
	public ResponseEntity<Check> showLastCheck() {
		Check temp = chrep.findAll().get(chrep.findAll().size()-1);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}

	// PARA SACAR PARAMETROS DE LA TIENDA USAR EL MODULO 1!!!!!
}
