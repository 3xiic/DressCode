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

import co.edu.unbosque.DressCode.model.Customer;
import co.edu.unbosque.DressCode.model.ResDelete;
import co.edu.unbosque.DressCode.model.ResUpdate;
import co.edu.unbosque.DressCode.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class ModuleTwoController {
	@Autowired
	private CustomerRepository crep;
	
	@PostMapping("/customers/new")
	public ResponseEntity<String> add(@RequestBody Customer cus) {
		crep.save(cus);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> showAll(){
		List<Customer> temp = crep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/customers/update")
    public ResponseEntity<String> update(@RequestBody ResUpdate res) {
		Customer temporal = crep.findById(Integer.parseInt(res.getStr1())).get();
		switch (res.getStr2()) {
		case "Cedula":
			temporal.setDocument(res.getStr3());
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
		case "E-mail":
			temporal.setEmail(res.getStr3());
			break;
		}
		crep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
	
	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> delete(@RequestBody ResDelete res) {
		Customer temporal = crep.findById(res.getId()).get();
		if (res.getStr().equals(temporal.getDocument())) {			
			crep.deleteById(res.getId());
			return ResponseEntity.status(HttpStatus.OK).body("Dato eliminado");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre no coincide");
	}
}
