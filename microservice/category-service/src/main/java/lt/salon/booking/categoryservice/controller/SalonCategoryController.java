package lt.salon.booking.categoryservice.controller;

import lombok.RequiredArgsConstructor;
import lt.salon.booking.categoryservice.dto.SalonDTO;
import lt.salon.booking.categoryservice.modal.Category;
import lt.salon.booking.categoryservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories/salon-owner")
@RequiredArgsConstructor
public class SalonCategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        Category savedCategory = categoryService.saveCategory(category, salonDTO);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        categoryService.deleteCategoryById(id, salonDTO.getId());

        return ResponseEntity.ok("Category deleted successfully.");
    }
}
