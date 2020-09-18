package com.imitation.restaurant.order.service;

import com.imitation.restaurant.deliveryPerson.model.DeliveryPerson;
import com.imitation.restaurant.deliveryPerson.service.DeliveryPersonService;
import com.imitation.restaurant.generic.service.DefaultService;
import com.imitation.restaurant.order.model.Order;
import com.imitation.restaurant.order.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class OrderService extends DefaultService<Order,OrderRepository> {

    @Autowired
    DeliveryPersonService deliveryPersonService;

    public Order updateOrder(@RequestBody Order order){
        Order findOrder = findOne(order.getId());

        if(findOrder.getDeliveryPerson() != null && findOrder.getStatus().equals(Order.Status.PROCESSING)){
            findOrder.setStatus(Order.Status.DELIVERED);
            findOrder.setDeliveryEndDateTime(LocalDateTime.now());
            save(findOrder);
            DeliveryPerson deliveryPerson = deliveryPersonService.findOne(findOrder.getDeliveryPerson().getId());
            deliveryPerson.setStatus(DeliveryPerson.Status.FULFILLED);
            deliveryPersonService.save(deliveryPerson);
        }
        return findOrder;
    }
}
