package lt.salon.booking.salonservice.service;

import lt.salon.booking.salonservice.modal.Salon;
import lt.salon.booking.salonservice.payload.dto.SalonDTO;
import lt.salon.booking.salonservice.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {

    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user, Long userId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);
}
