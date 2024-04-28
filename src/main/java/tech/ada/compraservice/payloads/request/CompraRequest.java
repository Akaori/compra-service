package tech.ada.compraservice.payloads.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import tech.ada.compraservice.payloads.request.entities.Envio;
import tech.ada.compraservice.payloads.request.entities.Pagamento;

@Data
@Schema
public class CompraRequest {
    private String carrinhoId;
    private String clienteId;
    private Pagamento pagamento;
    private Envio envio;
}
