package com.example.capstonebackend.controllers;
import com.example.capstonebackend.models.Order;
import com.example.capstonebackend.models.User;
import com.example.capstonebackend.models.UserDTO;
import com.example.capstonebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){
            List<Order> userOrders = userService.getUserOrders(id);
            return new ResponseEntity<>(userOrders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/notDeliveredOrders")
    public ResponseEntity<List<Order>> getUserNotDeliveredOrders(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){
            List<Order> userOrders = userService.getUserNotDeliveredOrders(id);
            return new ResponseEntity<>(userOrders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/deliveredOrders")
    public ResponseEntity<List<Order>> getUserDeliveredOrders(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){
            List<Order> userOrders = userService.getUserDeliveredOrders(id);
            return new ResponseEntity<>(userOrders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            User updatedUser = userService.editUser(id, userDTO);
            return new ResponseEntity<>(updatedUser, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/{userId}/orders/{orderId}")
    public ResponseEntity<User> assignOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            User assignedUser = userService.assignOrderToUser(userId, orderId);
            return new ResponseEntity<>(assignedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }
}
