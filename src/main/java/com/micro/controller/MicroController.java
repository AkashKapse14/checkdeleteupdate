package com.micro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.MicroProModel;
import com.micro.service.MicroService;



@RestController
@RequestMapping("/micro")
@CrossOrigin("*")
public class MicroController {

	@Autowired
	private MicroService microService;
	
//	@PostMapping("/")
//	public MicroProModel createUser(@RequestBody MicroProModel microProModel)
//	{
//		return this.microService.createUser(microProModel);
//	}
	
	@PostMapping("/")
	public ResponseEntity<MicroProModel> createUser(@RequestBody MicroProModel microProModel)
	{
		MicroProModel model=null;
		try {
			this.microService.createUser(microProModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(model);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(model);
		}
	}
	
	@GetMapping("/all")
	public List<MicroProModel> getAllUser()
	{
		List<MicroProModel> allUser = this.microService.getAllUser();
		return allUser;
	}
	
//	@GetMapping("/all")
//	public ResponseEntity<List<MicroProModel>> getAlluser(@RequestBody MicroProModel microProModel)
//	{
//		List<MicroProModel> allUser = this.microService.getAllUser();
//		if(allUser.size()<=0)
//		{
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(allUser);
//		}
//		return ResponseEntity.status(HttpStatus.FOUND).body(allUser);
//	}
	
	@GetMapping("/s/{id}")
	public MicroProModel getSingleUser(@PathVariable("id") int id)
	{
		return this.microService.getSingleUSer(id);
	}
	
//	@GetMapping("/s/{id}")
//	public ResponseEntity<MicroProModel> getSingleUser(@PathVariable("id") int id)
//	{
//		MicroProModel singleUSer = this.microService.getSingleUSer(id);
//		if(singleUSer==null)
//		{
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(singleUSer);
//		}
//		
//		return ResponseEntity.status(HttpStatus.FOUND).body(singleUSer);
//	}
	
//	@PutMapping("/up")
//	public MicroProModel updateUser(@RequestBody MicroProModel microProModel)
//	{
//		return this.microService.updateUser(microProModel);
//	}
	
	@PutMapping("/up")
	public ResponseEntity<MicroProModel> updateUser(@RequestBody MicroProModel microProModel)
	{
		MicroProModel updateUser = this.microService.updateUser(microProModel);
		return ResponseEntity.status(HttpStatus.OK).body(updateUser);
	}
	
//	@DeleteMapping("/d/{id}")
//	public void deleteUser(@PathVariable("id") int id)
//	{
//		this.microService.deleteUser(id);
//	}
	
	@DeleteMapping("/d/{id}")
	public ResponseEntity<MicroProModel> deleteUseer(@PathVariable("id") int id)
	{
		this.microService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
