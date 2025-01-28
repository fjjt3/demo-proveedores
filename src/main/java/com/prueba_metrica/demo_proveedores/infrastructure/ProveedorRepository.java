package com.prueba_metrica.demo_proveedores.infrastructure;

import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // Query method to find proveedores by clientId
    List<Proveedor> findByClientId(Long clientId);
}
