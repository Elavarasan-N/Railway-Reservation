package com.edubridge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>
{
	public List<Booking> findByCustomerCustomerId(long bookingId);
	public List<Booking> findBytrainId(long trainId);
	public void deleteByBookingId(long bookingId);
	public Booking findById(long bookingId);

}
