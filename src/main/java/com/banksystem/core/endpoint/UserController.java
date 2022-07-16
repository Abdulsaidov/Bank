package com.banksystem.core.endpoint;

import com.banksystem.core.dto.RequestUserDTO;
import com.banksystem.core.entity.User;
import com.banksystem.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//todo: handler for validation exception
@RestController
@RequestMapping("/v1/users")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid RequestUserDTO requestUserDTO) {
        userService.create(requestUserDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /** todo: patch должен обновлять часть бд. у тебя сейчас валидация
     * стоит на весь дто. т.е. если я хочу изменить только firstName будет ошибка
     * Или здесь нужен put метод или доработать patch...
     */
    @PatchMapping("/{userId}/edit")
    public ResponseEntity<HttpStatus> editUser(@PathVariable Long userId,
                                               @RequestBody @Valid RequestUserDTO requestUserDTO) {
        userService.updateUser(userId, requestUserDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long userId) {
        userService.removeUserById(userId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
