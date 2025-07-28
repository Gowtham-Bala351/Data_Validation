package ex.valid.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.valid.Model.User;
import ex.valid.repository.ValidationRepos;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/apival")
public class DataValidController 
{
	@Autowired
	private ValidationRepos repo;
	@PostMapping("/datavalidation")
	public ResponseEntity<?> checkData(@Valid @RequestBody User user)
	{
		repo.save(user);
		return new ResponseEntity(user,HttpStatus.CREATED);
	}
}
