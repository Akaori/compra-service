package tech.ada.compraservice.payloads.response;

import lombok.Data;

@Data
public class CompraInfoResponse {
    private String compraId;
    private String pagamentoId;
    private String envioId;
}
