package tech.ada.compraservice.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.ada.compraservice.payloads.request.CompraRequest;
import tech.ada.compraservice.payloads.response.CompraResponse;
import tech.ada.compraservice.service.RealizarCompraService;

@RestController
@RequestMapping(name = "/compras")
@RequiredArgsConstructor
public class CompraController {

    private final RealizarCompraService realizarCompraService;

    @PostMapping(value = "/compras")
    @Operation(summary = "Realizar a compra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Compra realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar a compra"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public CompraResponse realizarCompra(@RequestBody CompraRequest compraRequest){
        return realizarCompraService.realizarCompra(compraRequest);
    }
}
