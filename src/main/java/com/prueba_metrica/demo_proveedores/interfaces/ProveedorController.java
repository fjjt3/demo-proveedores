package com.prueba_metrica.demo_proveedores.interfaces;

import com.prueba_metrica.demo_proveedores.domain.ProveedorService;
import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/")
    public List<Proveedor> getAll() {
        return this.proveedorService.getAll();
    }

    @GetMapping("/{idCliente}")
    public List<Proveedor> obtenerProveedoresPorCliente(@PathVariable Long idCliente) {
        return this.proveedorService.obtenerProveedoresPorCliente(idCliente);
    }

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@Valid @RequestBody Proveedor proveedor) {
        return ResponseEntity.status(201).body(proveedorService.crearProveedor(proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id){
        proveedorService.borrarProducto(id);
        return ResponseEntity.noContent().build();
    }
}