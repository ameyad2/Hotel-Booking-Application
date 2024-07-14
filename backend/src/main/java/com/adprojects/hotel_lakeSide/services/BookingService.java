package com.adprojects.hotel_lakeSide.services;

import com.adprojects.hotel_lakeSide.exceptions.InvalidBookingRequestException;
import com.adprojects.hotel_lakeSide.exceptions.ResourceNotFoundException;
import com.adprojects.hotel_lakeSide.models.BookedRoom;
import com.adprojects.hotel_lakeSide.models.Room;
import com.adprojects.hotel_lakeSide.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService{

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    IRoomService roomService;

    public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public String saveBooking(Long roomId, BookedRoom bookingRequest) {
        if(bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())){
            throw new InvalidBookingRequestException("Check-in Date must come before Check-out Date");
        }
        Room room = roomService.getRoomById(roomId).get();
        List<BookedRoom> existingBookings = room.getBookings();
        boolean roomIsAvailable = roomIsAvailable(bookingRequest, existingBookings);
        if(roomIsAvailable){
            room.addBooking(bookingRequest);
            bookingRepository.save(bookingRequest);
        }
        else{
            throw new InvalidBookingRequestException("This room has been booked for the selected dates. ");
        }
        return bookingRequest.getBookingConfirmationCode();
    }

    private boolean roomIsAvailable(BookedRoom bookingRequest, List<BookedRoom> existingBookings) {

        return existingBookings.stream().noneMatch(existingBooking ->
                bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                || bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckOutDate())
                || (bookingRequest.getCheckInDate().isAfter(existingBooking.getCheckInDate()))
                && bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckOutDate())
                || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

                && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate()))
                || (bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate())

                && bookingRequest.getCheckOutDate().isAfter(existingBooking.getCheckOutDate()))

                || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckInDate()))

                || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate()))
        );
    }

    @Override
    public BookedRoom findByBookingConfirmationCode(String confirmationCode) {
        return bookingRepository.findByBookingConfirmationCode(confirmationCode).orElseThrow
                (()-> new ResourceNotFoundException("No Booking found with booking code : "+confirmationCode));
    }

    @Override
    public List<BookedRoom> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookedRoom> getBookingsByUserEmail(String email) {
        return bookingRepository.findByGuestEmail(email);
    }
}
