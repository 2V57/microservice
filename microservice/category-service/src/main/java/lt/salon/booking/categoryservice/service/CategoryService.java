package lt.salon.booking.categoryservice.service;

import lt.salon.booking.categoryservice.dto.SalonDTO;
import lt.salon.booking.categoryservice.modal.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getCategoryByIdSalon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id, Long salonID) throws Exception;
}
