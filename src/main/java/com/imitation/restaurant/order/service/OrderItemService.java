package com.imitation.restaurant.order.service;

import com.imitation.restaurant.generic.service.DefaultService;
import com.imitation.restaurant.order.model.OrderItem;
import com.imitation.restaurant.order.model.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends DefaultService<OrderItem,OrderItemRepository> {

}
