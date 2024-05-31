package co.edu.unbosque.DressCode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.DressCode.model.Check;
import co.edu.unbosque.DressCode.model.Purchase;
import co.edu.unbosque.DressCode.model.Sale;
import co.edu.unbosque.DressCode.model.SaleDetail;
import co.edu.unbosque.DressCode.repository.CheckRepository;
import co.edu.unbosque.DressCode.repository.PurchaseRepository;
import co.edu.unbosque.DressCode.repository.SaleDetailRepository;
import co.edu.unbosque.DressCode.repository.SaleRepository;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ModuleSevenController {
	@Autowired
	private CheckRepository chrep;
	@Autowired
	private SaleRepository srep;
	@Autowired
	private SaleDetailRepository sdrep;
	@Autowired
	private PurchaseRepository prep;

	// USAR METODOS DE MODULO 2 PARA LOS CUSTOMERS

	@GetMapping("/sales/bydocument")
	public ResponseEntity<List<Sale>> showSaleByDocument(@RequestParam String document) {
		List<Sale> temp = srep.findAll();
		List<Sale> l = new ArrayList<>();

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getCustomer_document().equals(document)) {
				l.add(temp.get(i));
			}
		}

		if (l.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(l);
	}

	@GetMapping("detailsales/bydocument")
	public ResponseEntity<List<SaleDetail>> showSaleDetailByDocument(@RequestParam String document) {
		List<Sale> sa = srep.findAll();
		Integer id_Sale = sa.get(0).getId_sale();

		List<SaleDetail> temp = sdrep.findAll();
		List<SaleDetail> l = new ArrayList<>();

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getId_sale().equals(id_Sale)) {
				l.add(temp.get(i));
			}
		}

		if (l.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(l);
	}

	@GetMapping("/purchase/bynit")
	public ResponseEntity<List<Purchase>> showPurchaseByNit(@RequestParam String nit) {
		List<Purchase> temp = prep.findAll();
		List<Purchase> l = new ArrayList<>();

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getNit_supplier().equals(nit)) {
				l.add(temp.get(i));
			}
		}

		if (l.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(l);
	}

	// Sacar el cheque
	@GetMapping("/checktable")
	public ResponseEntity<List<Check>> showLastCheck() {
		List<Check> temp = chrep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}

}
