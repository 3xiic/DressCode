package co.edu.unbosque.DressCode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.DressCode.model.Product;
import co.edu.unbosque.DressCode.model.ResDelete;
import co.edu.unbosque.DressCode.model.ResUpdate;
import co.edu.unbosque.DressCode.repository.ProductRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class ModuleFourController {
	@Autowired
	private ProductRepository prep;
	
	@PostMapping("/products/new")
	public ResponseEntity<String> add(@RequestBody Product prod) {
		prep.save(prod);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> showAll(){
		List<Product> temp = prep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/products/update")
    public ResponseEntity<String> update(@RequestBody ResUpdate res) {
		try {
			Product temporal = prep.findById(Integer.parseInt(res.getStr1())).get();
			switch (res.getStr2()) {
			case "Nombre":
				temporal.setName(res.getStr3());
				break;
			case "NIT":
				temporal.setNit_supplier(res.getStr3());
				break;
			case "PrecioCompra":
				Float temp = Float.parseFloat(res.getStr3());
				temporal.setPurchase_price(temp);
				break;
			case "PrecioVenta":
				Float temp2 = Float.parseFloat(res.getStr3());
				temporal.setSales_price(temp2);
				break;
			}
			prep.save(temporal);
			return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("No se actualizo");
		}
		
    }
	
	@DeleteMapping("/products/delete")
	public ResponseEntity<String> delete(@RequestBody ResDelete res) {
		Product temporal = prep.findById(res.getId()).get();
		if (res.getStr().equals(temporal.getName())) {			
			prep.deleteById(res.getId());
			return ResponseEntity.status(HttpStatus.OK).body("Dato eliminado");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("El Nombre del producto no coincide");
	}
}
