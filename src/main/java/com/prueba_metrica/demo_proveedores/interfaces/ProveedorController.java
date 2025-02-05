package com.prueba_metrica.demo_proveedores.interfaces;

import com.prueba_metrica.demo_proveedores.domain.ProveedorService;
import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/")
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor nuevoProveedor) {
        Proveedor proveedor = proveedorService.crearProveedor(nuevoProveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorActualizado) {
        try {
            Proveedor proveedor = proveedorService.actualizarProveedor(id, proveedorActualizado);
            return ResponseEntity.ok(proveedor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        try {
            proveedorService.eliminarProveedor(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}