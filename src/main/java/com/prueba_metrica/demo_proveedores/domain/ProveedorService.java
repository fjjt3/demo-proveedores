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
}