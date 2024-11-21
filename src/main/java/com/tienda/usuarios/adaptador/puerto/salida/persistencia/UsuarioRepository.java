package com.tienda.usuarios.adaptador.puerto.salida.persistencia;

import com.tienda.usuarios.aplicacion.puerto.salida.PuertoSalidaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements PuertoSalidaUsuario {
    private UsuarioCrudRepository repository;

    @Autowired
    public void setRepository(UsuarioCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existById(int id) {
        return repository.existsById(id);
    }
}
