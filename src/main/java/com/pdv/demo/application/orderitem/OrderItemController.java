package com.pdv.demo.application.orderitem;

import com.pdv.demo.application.orderitem.dto.OrderItemDto;
import com.pdv.demo.application.orderitem.service.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
im
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders/{orderId}/items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Adicionar um novo item ao pedido
    @PostMapping
    public ResponseEntity<OrderItemDto> addOrderItem(@PathVariable UUID orderId,
                                                     @Valid @RequestBody OrderItemDto orderItemDto) {
        OrderItemDto createdItem = orderItemService.addOrderItem(orderId, orderItemDto);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    // Obter um item de pedido específico
    @GetMapping("/{itemId}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable UUID orderId,
                                                         @PathVariable UUID itemId) {
        OrderItemDto orderItem = orderItemService.getOrderItemById(orderId, itemId);
        return orderItem != null ? ResponseEntity.ok(orderItem) : ResponseEntity.notFound().build();
    }

    // Obter todos os itens de um pedido
    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems(@PathVariable UUID orderId) {
        List<OrderItemDto> orderItems = orderItemService.getAllOrderItems(orderId);
        return ResponseEntity.ok(orderItems);
    }

    // Atualizar um item de pedido
    @PutMapping("/{itemId}")
    public ResponseEntity<OrderItemDto> updateOrderItem(@PathVariable UUID orderId,
                                                        @PathVariable UUID itemId,
                                                        @Valid @RequestBody OrderItemDto orderItemDto) {
        OrderItemDto updatedItem = orderItemService.updateOrderItem(orderId, itemId, orderItemDto);
        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
    }

    // Excluir um item do pedido
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable UUID orderId,
                                                @PathVariable UUID itemId) {
        boolean deleted = orderItemService.deleteOrderItem(orderId, itemId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
