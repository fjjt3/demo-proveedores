package com.prueba_metrica.demo_proveedores.domain;

import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import com.prueba_metrica.demo_proveedores.infrastructure.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService  {
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }


    public List<Proveedor> obtenerProveedoresPorCliente(Long idCliente) {
        return this.proveedorRepository.findByClientId(idCliente);
    }

    public List<Proveedor> getAll() {
        return this.proveedorRepository.findAll();
    }

    public Proveedor crearProveedor(Proveedor nuevoProveedor) {
        return proveedorRepository.save(nuevoProveedor);
    }

    public Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado) {
        return proveedorRepository.findById(id)
                .map(proveedor -> {
                    proveedor.setNombre(proveedorActualizado.getNombre());
                    proveedor.setFechaAlta(proveedorActualizado.getFechaAlta());
                    proveedor.setClientId(proveedorActualizado.getClientId());
                    return proveedorRepository.save(proveedor);
                })
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con id: " + id));
    }

    public void eliminarProveedor(Long id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Proveedor no encontrado con id: " + id);
        }
    }





}