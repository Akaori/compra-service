package tech.ada.compraservice.payloads.response;

import lombok.Data;
import tech.ada.compraservice.payloads.response.entities.Item;
import tech.ada.compraservice.payloads.response.enums.StatusCarrinho;

import java.util.List;

@Data
public class CarrinhoResponse {
    private String carrinhoId;
    private String clienteId;
    private Double valorTotal;
    private StatusCarrinho status;
    private List<Item> itens;
}
