package com.tienda.usuarios.aplicacion.puerto.entrada;

import com.tienda.exceptionHandler.excepciones.SearchItemNotFoundException;
import com.tienda.usuarios.dominio.Usuario;

public interface CasoUsoBloquearUsuario {
    Usuario bloquear(int id) throws SearchItemNotFoundException;
}
