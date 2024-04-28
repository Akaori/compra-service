package tech.ada.compraservice.payloads.response.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class Item {
    private String sku;
    private Double preco;
    private Double quantidade;
}