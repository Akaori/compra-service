package tech.ada.compraservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.compraservice.model.Compra;

import java.util.UUID;

public interface CompraRepository extends JpaRepository<Compra, UUID> {
}
