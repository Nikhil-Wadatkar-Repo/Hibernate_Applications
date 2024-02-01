package com.nit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private PAN_DetailsRepo panRepo;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee save = null;
		try {
			save = repo.save(employee);
			System.out.println("Employee saved");
		} catch (Exception e) {
			System.out.println("Error occurred during saving employee");
		}
		return save;
	}

	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		Employee save = new Employee();
		try {
			Optional<Employee> findById = repo.findById(id);
			if (findById.isPresent()) {
				save = findById.get();
			}

			System.out.println("Employee saved");
		} catch (Exception e) {
			System.out.println("Error occurred during saving employee");
		}
		return save;
	}

	@GetMapping("/getPan/{id}")
	public PAN_Details getPan(@PathVariable("id") Integer id) {
		PAN_Details save = new PAN_Details();
		try {
			Optional<PAN_Details> findById = panRepo.findById(id);
			if (findById.isPresent()) {
				save = findById.get();

			}

		} catch (Exception e) {
			System.out.println("Error occurred during getting  PAN details");
		}
		return save;

	}
}
