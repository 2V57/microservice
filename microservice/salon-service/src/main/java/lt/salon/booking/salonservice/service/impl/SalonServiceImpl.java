package lt.salon.booking.salonservice.service.impl;

import lombok.RequiredArgsConstructor;
import lt.salon.booking.salonservice.modal.Salon;
import lt.salon.booking.salonservice.payload.dto.SalonDTO;
import lt.salon.booking.salonservice.payload.dto.UserDTO;
import lt.salon.booking.salonservice.repository.SalonRepository;
import lt.salon.booking.salonservice.service.SalonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO request, UserDTO user) {

        Salon salon = new Salon();
        salon.setName(request.getName());
        salon.setAddress(request.getAddress());
        salon.setEmail(request.getEmail());
        salon.setCity(request.getCity());
        salon.setImages(request.getImages());
        salon.setOwnerId(user.getId());
        salon.setOpenTime(request.getOpenTime());
        salon.setCloseTime(request.getCloseTime());
        salon.setPhoneNumber(request.getPhoneNumber());

        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception {

        Salon existingSalon = salonRepository.findById(salonId).orElse(null);
        if (!salon.getOwnerId().equals(user.getId())){
            throw new Exception("you don't have permission to update this salon");
        }
        if (existingSalon != null){
            existingSalon.setCity(salon.getCity());
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            existingSalon.setOwnerId(user.getId());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());

            return salonRepository.save(existingSalon);
        }

        throw new Exception("Salon no exist.");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon == null){
            throw new Exception("Salon not exist.");
        }
        return salon;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
