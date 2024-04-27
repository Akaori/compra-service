package tech.ada.compraservice.payloads.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class CompraRequest {
    private String carrinhoId;
    private String clientId;
    private PagamentoRequest pagamento;
    private EnvioRequest envio;
}
