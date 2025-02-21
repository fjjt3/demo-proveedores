package com.prueba_metrica.demo_proveedores.infrastructure;

import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProveedorRepositoryTest {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Test
    void shouldFindProveedoresByIdCliente() {

        // WHEN
        List<Proveedor> result = proveedorRepository.findByClientId(5L);

        // THEN
        assertThat(result).hasSize(2);
    }

    @Test
    void shouldDeleteProveedor(){
        Proveedor proveedor1 = new Proveedor(1L, "Proveedor A", LocalDate.now(), 101L);
        Proveedor savedProveedor = proveedorRepository.save(proveedor1);

        proveedorRepository.deleteById(savedProveedor.getId());

        Optional<Proveedor> found = proveedorRepository.findById(savedProveedor.getId());
        assertFalse(found.isPresent());

    }
}