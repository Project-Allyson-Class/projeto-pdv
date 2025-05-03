package com.pdv.demo.core.orderitem;

import com.pdv.demo.application.orderitem.dto.OrderItemDto;
import com.pdv.demo.application.orderitem.entities.OrderItem;
import com.pdv.demo.application.orderitem.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItemDto addOrderItem(UUID orderId, OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem(orderId, orderItemDto.productId(), orderItemDto.quantity(), orderItemDto.price());
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return new OrderItemDto(savedOrderItem.getId(), savedOrderItem.getOrderId(), savedOrderItem.getProductId(), savedOrderItem.getQuantity(), savedOrderItem.getPrice());
    }

    public OrderItemDto getOrderItem(UUID orderItemId) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(orderItemId);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();
            return new OrderItemDto(orderItem.getId(), orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity(), orderItem.getPrice());
        }
        throw new RuntimeException("OrderItem not found");
    }

    public OrderItemDto updateOrderItem(UUID orderItemId, OrderItemDto orderItemDto) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(orderItemId);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();
            orderItem.setQuantity(orderItemDto.quantity());
            orderItem.setPrice(orderItemDto.price());
            OrderItem updatedOrderItem = orderItemRepository.save(orderItem);
            return new OrderItemDto(updatedOrderItem.getId(), updatedOrderItem.getOrderId(), updatedOrderItem.getProductId(), updatedOrderItem.getQuantity(), updatedOrderItem.getPrice());
        }
        throw new RuntimeException("OrderItem not found");
    }

    public void deleteOrderItem(UUID orderItemId) {
        if (orderItemRepository.existsById(orderItemId)) {
            orderItemRepository.deleteById(orderItemId);
        } else {
            throw new RuntimeException("OrderItem not found");
        }
    }
}
