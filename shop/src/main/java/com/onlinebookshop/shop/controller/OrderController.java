package com.onlinebookshop.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.service.OrderService;

@Controller
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> fetchOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order fetchOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    @ResponseBody
    public String addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return "Order Added Successfully";
    }

    @DeleteMapping("/orders/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        try {
            int rowsAffected = orderService.deleteOrderById(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Order deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order");
        }
    }

    @PutMapping("/orders/{id}")
    @ResponseBody
    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order order) {
        try {
            order.setId(id);
            int rowsAffected = orderService.updateOrder(order);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Order updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating order");
        }
    }
}
