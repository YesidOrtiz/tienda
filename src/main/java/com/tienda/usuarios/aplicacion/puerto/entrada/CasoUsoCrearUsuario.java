package com.tienda.usuarios.aplicacion.puerto.entrada;

import com.tienda.exceptionHandler.excepciones.InvalidInputException;
import com.tienda.usuarios.dominio.Usuario;

public interface CasoUsoCrearUsuario {
    Usuario crearUsuario(Usuario usuario) throws InvalidInputException;
}
