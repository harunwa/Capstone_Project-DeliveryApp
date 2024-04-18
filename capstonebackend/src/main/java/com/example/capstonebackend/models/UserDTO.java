package com.example.capstonebackend.models;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private List<OrderDTO> orders;
    private String name;

    public UserDTO(String name) {
        this.orders = new ArrayList<>();
        this.name = name;
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}