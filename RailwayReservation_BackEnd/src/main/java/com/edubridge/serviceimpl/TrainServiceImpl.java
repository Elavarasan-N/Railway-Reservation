package com.edubridge.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Train;
import com.edubridge.exception.TrainNotFoundException;
import com.edubridge.repository.TrainRepository;
import com.edubridge.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService 
{
	@Autowired
	private TrainRepository trainRepository;
	
	public TrainServiceImpl(TrainRepository trainRepository)
	{
		super();
		this.trainRepository = trainRepository;
	}

	@Override
	public Train addTrain(Train train)
	{
		return trainRepository.save(train);
	}

	@Override
	public List<Train> getAlltrain() 
	{
		return trainRepository.findAll();
	}

	@Override
	public Train getTrainById(long trainId) 
	{
		return trainRepository.findById(trainId).orElseThrow(()->new TrainNotFoundException("Train","trainId",trainId));
	}

	@Override
	public Train updateTrain(Train train, long trainId) 
	{
		Train existingTrain = trainRepository.findById(trainId).orElseThrow(()->new TrainNotFoundException("Train","trainId",trainId));
		existingTrain.setTrainName(train.getTrainName());
		existingTrain.setSource(train.getSource());
		existingTrain.setDestination(train.getDestination());
		existingTrain.setArrivalTime(train.getArrivalTime());
		existingTrain.setDepartureTime(train.getDepartureTime());
		existingTrain.setDistance(train.getDistance());
		existingTrain.setClassType(train.getClassType());
		existingTrain.setTotalSeats(train.getTotalSeats());
		existingTrain.setAvailableSeats(train.getAvailableSeats());
		
		trainRepository.save(existingTrain);
		return existingTrain;
	}

	@Override
	public void deleteTrain(long trainId) 
	{
		trainRepository.findById(trainId).orElseThrow(() -> new TrainNotFoundException("Train","trainId",trainId));
		trainRepository.deleteById(trainId);
	}

	@Override
	public List<Train> getTrainsByTrainName(String trainName) 
	{
		return trainRepository.getTrainsByTrainName(trainName);
	}

}
