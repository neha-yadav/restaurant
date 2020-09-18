package com.imitation.restaurant.order.service;

import com.imitation.restaurant.order.model.Order;
import com.imitation.restaurant.order.model.OrderBooking;
import com.imitation.restaurant.order.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderBookingService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    public Order bookOrder(@RequestBody OrderBooking orderBooking){

        orderBooking.getOrder().setStatus(Order.Status.INITIATED);
        orderBooking.getOrder().setDurationInMins(30);
        Order bookedOrder = orderService.save(orderBooking.getOrder());
        Set<OrderItem> orderItems = orderBooking.getOrderItems();
        orderItems.stream().forEach(x->x.setOrder(bookedOrder));
        if(bookedOrder != null){
            orderItemService.saveAll(orderItems.stream().collect(Collectors.toList()));
        }
        bookedOrder.setOrderItem(orderItems);
        return bookedOrder;
    }

}
