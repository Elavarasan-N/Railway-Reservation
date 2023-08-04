package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Train;

public interface TrainService 
{
	Train addTrain(Train train);
	List<Train> getAlltrain();
	Train getTrainById(long trainId);
	Train updateTrain(Train train, long trainId);
	void deleteTrain(long trainId);
	List<Train> getTrainsByTrainName(String trainName);
}
