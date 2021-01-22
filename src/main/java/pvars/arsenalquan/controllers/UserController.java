package pvars.arsenalquan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pvars.arsenalquan.message.ResponseMessage;
import pvars.arsenalquan.message.request.SearchForm;
import pvars.arsenalquan.models.User;
import pvars.arsenalquan.repositories.UserRepository;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Resource(name = "passwordEncoder")
    PasswordEncoder passwordEncoder;

    @PostMapping("/save")
    public ResponseEntity<?> add(@Valid @RequestBody User user) throws IOException {
        String password = user.getPassword();

        String encryptPassword = passwordEncoder.encode(password);
        user.setPassword(encryptPassword);

        userRepository.save(user);
        return new ResponseEntity<>(new ResponseMessage("Lưu thành công"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() throws IOException {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getSortDateASC")
    public ResponseEntity<List<User>> getSortDateASC() throws IOException {
        List<User> users = userRepository.sortDateASC();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getSortDateDESC")
    public ResponseEntity<List<User>> getSortDateDESC() throws IOException {
        List<User> users = userRepository.sortDateDESC();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showEditForm(@PathVariable Long id) {
        User users = userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Không tìm thấy bài viết này"));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity(new ResponseMessage("Xoá thành công"), HttpStatus.OK);
    }

    @PostMapping("/deteteUser")
    public ResponseEntity<?> deleteByUser(@RequestBody User User) {
        userRepository.deleteById(User.getId());
        return new ResponseEntity(new ResponseMessage("Xoá thành công"), HttpStatus.OK);
    }

    @PostMapping("/searchAll")
    public ResponseEntity<?> showEditForm(@RequestBody SearchForm searchString) {
        List<User> users = userRepository.findAll();
        users = users.stream().filter(
                item ->item.getId().toString().contains(searchString.getSearchString())
                        || item.getFullName().contains(searchString.getSearchString())
                        || item.getRoles().contains(searchString.getSearchString())
                        || item.getUsername().contains(searchString.getSearchString())
                        || item.getCreateDate().toString().contains(searchString.getSearchString())
                        || item.getUpdateDate().toString().contains(searchString.getSearchString())
                        || item.getCreateBy().toString().contains(searchString.getSearchString())
                        || item.getUpdateBy().toString().contains(searchString.getSearchString())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
