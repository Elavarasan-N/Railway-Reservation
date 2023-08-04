package com.edubridge.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.edubridge.entity.Train;
import com.edubridge.service.TrainService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/train")
public class TrainController 
{
	@Autowired
	private TrainService trainService;

	public TrainController(TrainService trainService) {
		super();
		this.trainService = trainService;
	}
	
    //to add Train
	@PostMapping("/add")
	public ResponseEntity<Train> addTrain(@Valid @RequestBody Train train)
	{
		return new ResponseEntity<Train>(trainService.addTrain(train),HttpStatus.CREATED);
	}
	
	//to get train 
	@GetMapping ("/trains") 
	public List<Train> getAlltrain()
	{
		return trainService.getAlltrain();
    }
	
	//to get train details
	@GetMapping("/{trainId}")
	public ResponseEntity<Train> getTrainById(@PathVariable("trainId") long trainId)
	{
		System.out.println("Inside train controller");
		return new ResponseEntity<Train>(trainService.getTrainById(trainId),HttpStatus.OK);
	}
	
	//update train details
	@PutMapping("/{trainId}")
	public ResponseEntity<Train> updateTrain(@Valid @PathVariable("trainId") long trainId, @RequestBody Train train)
	{
		return new ResponseEntity<Train> (trainService.updateTrain(train, trainId),HttpStatus.OK);
	}
	
	//delete Train details
	@DeleteMapping("/{trainId}")
	public ResponseEntity<Boolean> deleteTrain(@PathVariable long trainId)
	{
		trainService.deleteTrain(trainId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
	//search train by name
	@GetMapping("search/{trainName}")
	public List<Train> getTrainsByTrainName(@PathVariable String trainName)
	{
		System.out.println("Names = "+trainName);
		return trainService.getTrainsByTrainName(trainName);
	}
}
