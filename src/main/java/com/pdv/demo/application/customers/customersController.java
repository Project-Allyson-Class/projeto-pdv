package com.pdv.demo.application.customers;

import com.pdv.demo.application.customers.dtos.CustomerDto;
import com.pdv.demo.core.customers.ICustomersUseCase;
import com.pdv.demo.core.customers.entities.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomersUseCase service;

    @Operation(description = "Cria um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna o cliente criado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))),
            @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CustomerDto data) {
        return new ResponseEntity<>(this.service.create(data), HttpStatus.CREATED);
    }

    @Operation(description = "Lista todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna uma lista com todos os clientes",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Customer.class)))),
            @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @Operation(description = "Lista um cliente pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um cliente pelo seu id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))),
            @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        var customer = this.service.getById(id);

        if (customer == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @Operation(description = "Atualiza um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o cliente atualizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))),
            @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid CustomerDto data) {
        return new ResponseEntity<>(this.service.update(data), HttpStatus.OK);
    }

    @Operation(description = "Exclui um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
