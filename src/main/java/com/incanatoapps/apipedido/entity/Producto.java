package com.incanatoapps.apipedido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64, nullable = true)
    private String codigo;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal precio;
}
