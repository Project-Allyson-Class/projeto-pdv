package com.pdv.demo.application.products;

import com.pdv.demo.application.products.dtos.ProductDto;
import com.pdv.demo.core.products.IProductsUseCase;
import com.pdv.demo.core.products.entities.Product;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductsUseCase service;

    @Operation(description = "Cria um produto")
    @ApiResponses(value =  {
        @ApiResponse(responseCode = "201", description = "Retorna o produto criado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Product.class))
        ),
        @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductDto data) {
        return new ResponseEntity<>(this.service.create(data), HttpStatus.CREATED);
    }

    @Operation(description = "Lista todos os produtos")
    @ApiResponses(value =  {
        @ApiResponse(responseCode = "200", description = "Retorna uma lista com todos os produtos",
            content = @Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Product.class)))),
        @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @Operation(description = "Lista um produto pelo seu id")
    @ApiResponses(value =  {
        @ApiResponse(responseCode = "200", description = "Retorna um produto pelo seu id",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Product.class))),
        @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        var product = this.service.getById(id);

        if (product == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Operation(description = "Atualiza um produto")
    @ApiResponses(value =  {
        @ApiResponse(responseCode = "200", description = "Retorna o produto atualizado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Product.class))),
        @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid ProductDto data) {
        return new ResponseEntity<>(this.service.update(data), HttpStatus.OK);
    }

    @Operation(description = "Exclui um produto")
    @ApiResponses(value =  {
        @ApiResponse(responseCode = "204"),
        @ApiResponse(responseCode = "500", description = "Retorna o erro específico")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
