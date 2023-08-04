package com.edubridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edubridge.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> 
{
	public List<Train> findByTrainId(long trainId);
	@Query(value = " select * from train_table where train_name like ?1",nativeQuery = true)
	List<Train> getTrainsByTrainName(String trainName);
}
