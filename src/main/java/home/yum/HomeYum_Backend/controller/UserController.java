package home.yum.HomeYum_Backend.controller;

import home.yum.HomeYum_Backend.user.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid UserDTO data){
        userService.saveUser(data);
    }

    @GetMapping
    public ResponseEntity<Page<ListUserDTO>> getAllUsers(Pageable pagination) {
        Page<ListUserDTO> userPage = userService.findAllUsers(pagination);
        return ResponseEntity.ok(userPage);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ListUserDTO> getUserById(@PathVariable Long userId) {
        User user = userService.findById(userId);

        if (user != null){
            ListUserDTO userDTO = new ListUserDTO(user);
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateUserDTO data) {
        userService.updateUser(data);
    }

    @DeleteMapping("{userId}")
    @Transactional
    public void delete(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
