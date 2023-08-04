package com.edubridge.controller;

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

import com.edubridge.entity.Booking;
import com.edubridge.service.BookingService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/booking")
public class BookingController 
{
	
	@Autowired
	private BookingService bookingService;

	public BookingController(BookingService bookingService) 
	{
		super();
		this.bookingService = bookingService;
	}
	
	//adding booking details
	@PostMapping("{trainId}/{customerId}")
	public ResponseEntity<Booking> addBooking(@PathVariable long trainId,@PathVariable long customerId,@RequestBody  Booking booking)
	{
		return new ResponseEntity<Booking>(bookingService.addBooking(booking,trainId,customerId),HttpStatus.CREATED);
	}
	
	//updating booking details
	/*@PutMapping("/{bookingId}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("bookingId") long bookingId, @RequestBody Booking booking)
	{
		return new ResponseEntity<Booking> (bookingService.updateBooking(booking, bookingId),HttpStatus.OK);
	}*/
	
	//get all booking details
	@GetMapping("/bookings")
	public List<Booking> getAllBooking()
	{
		return bookingService.getAllBooking();
	}
	
	//get booking details by customer id
	@GetMapping("/customer/{customerId}")
	public List<Booking> getBookingByCustomerId(@PathVariable long customerId)
	{
		return bookingService.getBookingByCustomerId(customerId);
	}
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable long bookingId)
	{
		return new ResponseEntity<Booking>(bookingService.getBookingById(bookingId),HttpStatus.OK);
	}
	
	//to check availability of train
	/*@GetMapping("/{trainId}")	
	public ResponseEntity<Boolean> getBookingByTrainId(@PathVariable("trainId") long trainId)
	{
		return new ResponseEntity<Boolean>(bookingService.getBookingByTrainId(trainId),HttpStatus.OK);

	}*/
	
	//to delete or cancel booking
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable("bookingId") long bookingId)
	{
		bookingService.deleteBooking(bookingId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
	}