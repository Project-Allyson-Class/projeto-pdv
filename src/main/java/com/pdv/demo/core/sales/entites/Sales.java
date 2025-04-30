package com.pdv.demo.core.sales.entites;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Sales {


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    public class Venda {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDateTime dataHora;

        private BigDecimal valorTotal;

        private String formaPagamento; // Ex: "DINHEIRO", "CARTAO", "PIX"

        private String status; // Ex: "FINALIZADA", "CANCELADA"

        @OneToOne
        @JoinColumn(name = "order_id")
        private Order order;

        // Construtores
        public Venda() {}

        public Venda(LocalDateTime dataHora, BigDecimal valorTotal, String formaPagamento, String status, Order order) {
            this.dataHora = dataHora;
            this.valorTotal = valorTotal;
            this.formaPagamento = formaPagamento;
            this.status = status;
            this.order = order;
        }

        // Getters e Setters

        public Long getId() {
            return id;
        }

        public LocalDateTime getDataHora() {
            return dataHora;
        }

        public void setDataHora(LocalDateTime dataHora) {
            this.dataHora = dataHora;
        }

        public BigDecimal getValorTotal() {
            return valorTotal;
        }

        public void setValorTotal(BigDecimal valorTotal) {
            this.valorTotal = valorTotal;
        }

        public String getFormaPagamento() {
            return formaPagamento;
        }

        public void setFormaPagamento(String formaPagamento) {
            this.formaPagamento = formaPagamento;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }

}
