package com.imitation.restaurant.order.controller;

import com.imitation.restaurant.generic.controller.DefaultController;
import com.imitation.restaurant.order.model.Order;
import com.imitation.restaurant.order.model.OrderBooking;
import com.imitation.restaurant.order.service.OrderBookingService;
import com.imitation.restaurant.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController extends DefaultController<Order,OrderService> {

    @Autowired
    OrderBookingService orderBookingService;

    @PostMapping("/create")
    public Order save(@RequestBody OrderBooking orderBooking){
        return orderBookingService.bookOrder(orderBooking);
    }

    @PutMapping("/update")
    public Order updateOrderStatus(@RequestBody Order order){
        return service.updateOrder(order);
    }
}



