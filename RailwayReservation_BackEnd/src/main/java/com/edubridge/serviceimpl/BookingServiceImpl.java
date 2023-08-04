package com.edubridge.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Booking;
import com.edubridge.entity.Customer;
import com.edubridge.entity.Train;
import com.edubridge.exception.BookingNotFoundException;
import com.edubridge.repository.BookingRepository;
import com.edubridge.service.BookingService;
import com.edubridge.service.CustomerService;
import com.edubridge.service.TrainService;

@Service
public class BookingServiceImpl implements BookingService 
{
	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private TrainService trainService;
	@Autowired
	private CustomerService customerService;

	@Override
	public Booking addBooking(Booking booking, long trainId, long customerId) 
	{
		Train train = trainService.getTrainById(trainId);
		Customer customer=customerService.getCustomerById(customerId);
		booking.setTrainName(train.getTrainName());
		booking.setTrainId(train.getTrainId());
		booking.setTrainPrice(train.getTrainPrice());
		booking.setDepartureTime(train.getDepartureTime());
		booking.setClassType(train.getClassType());
		booking.setFirstName(customer.getFirstName());
		booking.setLastName(customer.getLastName());
        booking.setCustomer(customer);
		return bookingRepository.save(booking);
	}

	/*@Override
	public Booking updateBooking(Booking booking, long bookingId) 
	{
		Booking existingBooking=bookingRepository.findById(bookingId).orElseThrow(()->new BookingNotFoundException("Booking","bookingId",bookingId));
		existingBooking.setBookedDate(booking.getBookedDate());
		existingBooking.setClassType(booking.getClassType());
		existingBooking.setCustomer(booking.getCustomer());
		existingBooking.setTrainId(booking.getTrainId());
		existingBooking.setTrainName(booking.getTrainName());
		existingBooking.setTrainPrice(booking.getTrainPrice());
		existingBooking.setBookedDate(booking.getBookedDate());
		
		bookingRepository.save(existingBooking);
		return existingBooking;
	}*/

	@Override
	public List<Booking> getAllBooking() 
	{
		return bookingRepository.findAll();
	}


	@Override
	public void deleteBooking(long bookingId) 
	{
		bookingRepository.findById(bookingId);
		bookingRepository.deleteById(bookingId);
		
	}

	@Override
	public Booking getBookingById(long bookingId) 
	{
		return bookingRepository.findById(bookingId);
	}

	@Override
	public List<Booking> getBookingByCustomerId(long customerId) 
	{
		return bookingRepository.findByCustomerCustomerId(customerId);
	}

}
