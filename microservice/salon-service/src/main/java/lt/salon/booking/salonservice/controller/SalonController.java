package lt.salon.booking.salonservice.controller;

import lombok.RequiredArgsConstructor;
import lt.salon.booking.salonservice.mapper.SalonMapper;
import lt.salon.booking.salonservice.modal.Salon;
import lt.salon.booking.salonservice.payload.dto.SalonDTO;
import lt.salon.booking.salonservice.payload.dto.UserDTO;
import lt.salon.booking.salonservice.service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

// http://localhost:5002/api/salons
    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO, userDTO);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO1);
    }

// http://localhost:5002/api/salons/2
    @PutMapping("/{salonId}")
    public ResponseEntity<SalonDTO> updateSalon(
            @PathVariable Long salonId,
            @RequestBody SalonDTO salonDTO
    ) throws Exception {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(1L);

        System.out.println("----------- " + salonId);
        System.out.println("----------- " + salonDTO.getEmail());

        Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO1);
    }

// http://localhost:5002/api/salons
    @GetMapping()
    public ResponseEntity <List<SalonDTO>> getSalons() throws Exception {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(1L);
        List<Salon> salons = salonService.getAllSalons();

        List<SalonDTO> salonDTOS = salons.stream().map(SalonMapper::mapToDTO).toList();
        return ResponseEntity.ok(salonDTOS);
    }

    // http://localhost:5002/api/salons/5
    @GetMapping("/{salonId}")
    public ResponseEntity <SalonDTO> getSalonById(@PathVariable Long salonId) throws Exception {

        Salon salon = salonService.getSalonById(salonId);

        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }

// http://localhost:5002/api/salons/search?city=mumbai
    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(
            @RequestParam("city") String city
    ){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        List<Salon> salons = salonService.searchSalonByCity(city);

        List<SalonDTO> salonDTOS = salons.stream().map(SalonMapper::mapToDTO).toList();

    return ResponseEntity.ok(salonDTOS);
    }

    // http://localhost:5002/api/salons/5
    @GetMapping("owner//{salonId}")
    public ResponseEntity <SalonDTO> getSalonByOwnerId(Long salonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon = salonService.getSalonByOwnerId(userDTO.getId());

        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }
}
