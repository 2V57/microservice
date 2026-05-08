package lt.salon.booking.categoryservice.controller;

import lombok.RequiredArgsConstructor;
import lt.salon.booking.categoryservice.modal.Category;
import lt.salon.booking.categoryservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/salons/{id}")
    public ResponseEntity<Set<Category>> getCategoriesBySalon(@PathVariable Long id){
        Set<Category> categories = categoryService.getCategoryByIdSalon(id);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) throws Exception {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
}
