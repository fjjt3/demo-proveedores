package com.prueba_metrica.demo_proveedores.domain;

import com.prueba_metrica.demo_proveedores.infrastructure.entity.Proveedor;
import com.prueba_metrica.demo_proveedores.infrastructure.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService  {
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }


    public List<Proveedor> obtenerProveedoresPorCliente(Long idCliente) {
        return this.proveedorRepository.findByClientId(idCliente);
    }

    public Optional<Proveedor> obtenerProveedoresPorId(Long id) {
        return this.proveedorRepository.findById(id);
    }

    public List<Proveedor> getAll() {
        return this.proveedorRepository.findAll();
    }

    public Proveedor crearProveedor (Proveedor proveedor){return this.proveedorRepository.save(proveedor);}

    public void borrarProveedor(Long id){
        proveedorRepository.deleteById(id);
    }
}