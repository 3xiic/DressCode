package co.edu.unbosque.DressCode.controller;

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

import co.edu.unbosque.DressCode.model.Parameter;
import co.edu.unbosque.DressCode.repository.ParameterRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class ModuleOneController {
	@Autowired
	private ParameterRepository prep;
	
	@PostMapping("/parameters/new")
	public ResponseEntity<String> add(@RequestBody Parameter pa){
		prep.save(pa);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/parameters")
	public ResponseEntity<List<Parameter>> showAll(){
		List<Parameter> temp = prep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/parameters/update")
    public ResponseEntity<String> update(@RequestBody Parameter pa) {
		Parameter temporal = prep.findById(pa.getNit()).get();
		temporal = new Parameter(pa.getNit(), pa.getType(), pa.getName(), pa.getCity(), pa.getIva(), pa.getInterest_rate(), pa.getBank(), pa.getAccount(), pa.getManager_name());
		prep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
}
