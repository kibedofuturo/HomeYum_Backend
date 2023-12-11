package home.yum.HomeYum_Backend.controller;

import home.yum.HomeYum_Backend.user.User;
import home.yum.HomeYum_Backend.user.UserDTO;
import home.yum.HomeYum_Backend.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid UserDTO data){
        repository.save(new User(data));
    }
}
