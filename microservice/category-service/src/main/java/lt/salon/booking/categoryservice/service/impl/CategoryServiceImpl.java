package lt.salon.booking.categoryservice.service.impl;

import lombok.RequiredArgsConstructor;
import lt.salon.booking.categoryservice.dto.SalonDTO;
import lt.salon.booking.categoryservice.modal.Category;
import lt.salon.booking.categoryservice.repository.CategoryRepository;
import lt.salon.booking.categoryservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {

        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setId(category.getId());
        newCategory.setImage(category.getImage());

        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getCategoryByIdSalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
