package com.pdv.demo.core.oder;

import com.pdv.demo.core.orderitem.OrderItem;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private String status; // Ex: "EM_ABERTO", "FINALIZADO", "CANCELADO"

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> itens;

    public Order() {
        this.dataHora = LocalDateTime.now();
        this.status = "EM_ABERTO";
    }

    // Getters e Setters
}
