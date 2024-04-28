package tech.ada.compraservice.mapping;

import lombok.experimental.UtilityClass;
import tech.ada.compraservice.model.Compra;
import tech.ada.compraservice.payloads.response.CompraResponse;

@UtilityClass
public class ConvertCompraToCompraResponse {

    public CompraResponse convertToCompraResponse(Compra compra) {
        CompraResponse compraResponse = new CompraResponse();
        compraResponse.setCompraId(String.valueOf(compra.getId()));
        compraResponse.setStatus(String.valueOf(compra.getStatus()));

        return compraResponse;
    }
}
