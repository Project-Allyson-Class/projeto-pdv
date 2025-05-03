package com.pdv.demo.core.sales.entites;

import com.pdv.demo.core.oder.Order;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private BigDecimal valorTotal;

    private String formaPagamento; // Ex: "DINHEIRO", "CARTAO", "PIX"

    private String status; // Ex: "FINALIZADA", "CANCELADA"

    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;

    public Sale() {
        this.dataHora = LocalDateTime.now();
        this.status = "FINALIZADA";
    }

    // Getters e Setters
}
