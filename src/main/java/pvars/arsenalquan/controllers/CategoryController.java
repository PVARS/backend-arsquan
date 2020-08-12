package pvars.arsenalquan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pvars.arsenalquan.message.ResponseMessage;
import pvars.arsenalquan.message.request.SearchForm;
import pvars.arsenalquan.models.Category;
import pvars.arsenalquan.repositories.CategoryRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/save")
    public ResponseEntity<?> add(@Valid @RequestBody Category category) throws IOException {
        categoryRepository.save(category);
        return new ResponseEntity<>(new ResponseMessage("Lưu thành công"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll() throws IOException {
        List<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showEditForm(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Không tìm thấy danh mục này"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody Long id) {
        categoryRepository.deleteById(id);
        return new ResponseEntity(new ResponseMessage("Xoá thành công"), HttpStatus.OK);
    }

    @PostMapping("/deteteCategory")
    public ResponseEntity<?> deleteByCategory(@RequestBody Category category) {
        categoryRepository.deleteById(category.getId());
        return new ResponseEntity(new ResponseMessage("Xoá thành công"), HttpStatus.OK);
    }

    @PostMapping("/searchAllColumn")
    public ResponseEntity<?> showEditForm(@RequestBody SearchForm searchString) {
        List<Category> categories = categoryRepository.findAll();
        categories = categories.stream().filter(
            item ->item.getId().toString().contains(searchString.getSearchString())
                || item.getLoaiTin().contains(searchString.getSearchString())
                || item.getNgayTao().toString().contains(searchString.getSearchString())
                || item.getNgayThayDoi().toString().contains(searchString.getSearchString())
                || item.getTaoBoi().toString().contains(searchString.getSearchString())
                || item.getThayDoiBoi().toString().contains(searchString.getSearchString())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
