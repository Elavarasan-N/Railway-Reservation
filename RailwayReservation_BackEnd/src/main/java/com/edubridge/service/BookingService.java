package com.edubridge.service;

import java.util.List;

import com.edubridge.entity.Booking;

public interface BookingService 
{
	Booking addBooking(Booking booking, long trainId,long customerId);
	//Booking updateBooking(Booking booking,long bookingId);
	List<Booking> getBookingByCustomerId(long customerId);
	List<Booking> getAllBooking();
	Booking getBookingById(long bookingId);
	void deleteBooking(long bookingId);
	//Boolean getAvailability(Date checkIn,Date checkOut,long roomId);
	
}
