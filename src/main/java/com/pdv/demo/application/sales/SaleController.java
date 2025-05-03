package com.pdv.demo.application.sales;

import com.pdv.demo.core.products.entities.ISalesUseCase;
import com.pdv.demo.core.sales.entites.Sale;
import com.pdv.demo.core.sales.entities.Sale;
import com.pdv.demo.application.sales.dtos.SaleDto;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISalesUseCase salesService;

    @Operation(description = "Cria uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venda criada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "500", description = "Erro ao criar a venda")
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SaleDto saleDto) {
        // Aqui você pode adicionar mapeamento de SaleDto para Sale se necessário
        Sale sale = new Sale(); // Supondo que o SaleDto tenha as propriedades de Sale
        sale.setAmount(saleDto.getAmount());
        // Outras propriedades...

        Sale createdSale = salesService.create(sale);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @Operation(description = "Lista todas as vendas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de vendas",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "500", description = "Erro ao listar vendas")
    })
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(salesService.getAll(), HttpStatus.OK);
    }

    @Operation(description = "Lista uma venda por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a venda pelo ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar a venda")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        Sale sale = salesService.getById(id);
        if (sale == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @Operation(description = "Deleta uma venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Venda excluída com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao excluir a venda")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        salesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
