package com.incanatoapps.apipedido.controller;

import com.incanatoapps.apipedido.entity.Producto;
import com.incanatoapps.apipedido.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoServiceImpl service;

    @GetMapping
    public ResponseEntity<Page<Producto>> findAll(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value= "limit", required = false, defaultValue = "5") int pageSize
    ){
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(service.findAll(pageable, search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto obj){
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
