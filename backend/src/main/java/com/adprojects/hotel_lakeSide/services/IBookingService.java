package com.adprojects.hotel_lakeSide.services;


import com.adprojects.hotel_lakeSide.models.BookedRoom;

import java.util.List;

public interface IBookingService {

    void cancelBooking(Long bookingId);

    String saveBooking(Long roomId, BookedRoom bookingRequest);

    BookedRoom findByBookingConfirmationCode(String confirmationCode);

    List<BookedRoom> getAllBookings();

    List<BookedRoom> getBookingsByUserEmail(String email);
}
