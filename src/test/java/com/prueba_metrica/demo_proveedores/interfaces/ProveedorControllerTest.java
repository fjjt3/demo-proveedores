package com.prueba_metrica.demo_proveedores.interfaces;

import com.prueba_metrica.demo_proveedores.domain.ProveedorService;
import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProveedorController.class)
class ProveedorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProveedorService proveedorService;

    @Test
    void shouldReturnProveedoresForGivenIdCliente() throws Exception {

        // GIVEN
        Proveedor proveedor1 = new Proveedor(1L, "Proveedor A", LocalDate.now(), 101L);
        Proveedor proveedor2 = new Proveedor(2L, "Proveedor B", LocalDate.now(), 101L);

        // WHEN
        when(proveedorService.obtenerProveedoresPorCliente(101L)).thenReturn(List.of(proveedor1, proveedor2));

        // THEN
        mockMvc.perform(get("/proveedores/101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nombre").value("Proveedor A"))
                .andExpect(jsonPath("$[1].nombre").value("Proveedor B"));
    }
}

