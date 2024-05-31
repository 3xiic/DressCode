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

import co.edu.unbosque.DressCode.model.ResDelete;
import co.edu.unbosque.DressCode.model.ResUpdate;
import co.edu.unbosque.DressCode.model.Supplier;
import co.edu.unbosque.DressCode.repository.SupplierRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class ModuleThreeController {
	@Autowired
	private SupplierRepository srep;
	
	@PostMapping("/suppliers/new")
	public ResponseEntity<String> add(@RequestBody Supplier sup) {
		srep.save(sup);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/suppliers")
	public ResponseEntity<List<Supplier>> showAll(){
		List<Supplier> temp = srep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/suppliers/update")
    public ResponseEntity<String> update(@RequestBody ResUpdate res) {
		Supplier temporal = srep.findById(Integer.parseInt(res.getStr1())).get();
		switch (res.getStr2()) {
		case "NIT":
			temporal.setNit(res.getStr3());
			break;
		case "Nombre":
			temporal.setName(res.getStr3());
			break;
		case "Direccion":
			temporal.setAddress(res.getStr3());
			break;
		case "Telefono":
			temporal.setPhone_number(res.getStr3());
			break;
		case "Ciudad":
			temporal.setCity(res.getStr3());
			break;
		}
		srep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
	
	@DeleteMapping("/suppliers/delete")
	public ResponseEntity<String> delete(@RequestBody ResDelete res) {
		Supplier temporal = srep.findById(res.getId()).get();
		if (res.getStr().equals(temporal.getNit())) {			
			srep.deleteById(res.getId());
			return ResponseEntity.status(HttpStatus.OK).body("Dato eliminado");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("El NIT no coincide");
	}
}
