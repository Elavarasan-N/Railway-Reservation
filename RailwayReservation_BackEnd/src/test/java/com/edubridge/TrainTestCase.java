package com.edubridge;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edubridge.entity.Train;
import com.edubridge.service.TrainService;

@SpringBootTest
class TrainTestCase {

	@Autowired
	private TrainService trainService;
	
	static Train train = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		LocalDateTime d=LocalDateTime.now();
		train = new Train();
		train.setTrainImage("./assets/train2.png");
		train.setTrainName("Chollan Express");
		train.setSource("Salem");
		train.setDestination("Kanyakumari");
		train.setDepartureTime(d);
		train.setArrivalTime(d);
		train.setClassType("Sleeper");
		train.setTotalSeats(200);
		train.setAvailableSeats(160);
		train.setTrainPrice(240);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertNotNull(trainService.addTrain(train));
	}

}
