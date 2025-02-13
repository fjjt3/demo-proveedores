package com.prueba_metrica.demo_proveedores.domain;

import com.prueba_metrica.demo_proveedores.infrastructure.ProveedorRepository;
import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProveedorServiceTest {

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private ProveedorService proveedorService;


    @Test
    void shouldReturnProveedoresByIdCliente() {

        // GIVEN
        Proveedor proveedor1 = new Proveedor(1L, "Proveedor A", LocalDate.now(), 101L);
        Proveedor proveedor2 = new Proveedor(2L, "Proveedor B", LocalDate.now(), 101L);

        // WHEN
        when(proveedorRepository.findByClientId(101L)).thenReturn(List.of(proveedor1, proveedor2));

        // THEN
        List<Proveedor> result = proveedorService.obtenerProveedoresPorCliente(101L);

        assertThat(result).hasSize(2);
        assertThat(result).extracting("nombre").containsExactlyInAnyOrder("Proveedor A", "Proveedor B");
    }

    @Test
    void shouldCrerateProveedor(){
        Proveedor proveedor3= new Proveedor(1l, "Pepsi", LocalDate.now(), 8L);
        Proveedor savedProveedor = new Proveedor(1L, "Pepsi",LocalDate.now(), 8L );
        when(proveedorRepository.save(any(Proveedor.class))).thenReturn(savedProveedor);

        Proveedor result =  proveedorService.crearProveedor(proveedor3);

        assertNotNull(result);
        assertEquals(savedProveedor.getId(), result.getId());
        assertEquals(savedProveedor.getNombre(), result.getNombre());
        assertEquals(savedProveedor.getClientId(), result.getClientId());
        verify(proveedorRepository).save(proveedor3);




    }
}