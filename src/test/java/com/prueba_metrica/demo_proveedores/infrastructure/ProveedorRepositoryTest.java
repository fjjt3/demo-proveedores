package com.prueba_metrica.demo_proveedores.infrastructure;

import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}