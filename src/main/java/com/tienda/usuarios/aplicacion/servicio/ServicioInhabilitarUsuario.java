package com.tienda.usuarios.aplicacion.servicio;

import com.tienda.exceptionHandler.excepciones.SearchItemNotFoundException;
import com.tienda.usuarios.aplicacion.puerto.entrada.CasoUsoBloquearUsuario;
import com.tienda.usuarios.aplicacion.puerto.salida.PuertoSalidaUsuario;
import com.tienda.usuarios.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioBloquearUsuario implements CasoUsoBloquearUsuario {
    private PuertoSalidaUsuario repository;

    @Autowired
    public ServicioBloquearUsuario(PuertoSalidaUsuario repository) {
        this.repository = repository;
    }

    @Override
    public Usuario bloquear(int id) throws SearchItemNotFoundException {
        if (!repository.existById(id)){
            throw new SearchItemNotFoundException("El usuario no existe");
        }
        return null;
    }
}
