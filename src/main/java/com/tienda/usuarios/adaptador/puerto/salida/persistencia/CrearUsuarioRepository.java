package com.tienda.usuarios.adaptador.puerto.salida.persistencia;

import com.tienda.exceptionHandler.excepciones.InvalidInputException;
import com.tienda.usuarios.adaptador.modelo.UsuarioPersistenceModel;
import com.tienda.usuarios.aplicacion.puerto.salida.PuertoCrearUsuario;
import com.tienda.usuarios.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrearUsuarioRepository implements PuertoCrearUsuario {
    private UsuarioCrudRepository repository;
    private MapperRepositoryToDomainUsuario mapper;
    //private String regexContrasena = "^(?=.*[a-zA-Z])[a-zA-Z0-9#, ]+$";

    @Autowired
    public void setMapper(MapperRepositoryToDomainUsuario mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(UsuarioCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws InvalidInputException {
        if (usuario.getContrasena().length()<8){
            throw new InvalidInputException("La contraseña debe tener almenos 8 caracteres");
        }
        /*if (!usuario.getContrasena().matches(regexContrasena)) {
            throw new InvalidInputException("el campo contraseña no cumple con los requisitos");
        }*/
        UsuarioPersistenceModel response = repository.save(mapper.toPersistenceModel(usuario));
        return mapper.toDomainModel(response);
    }
}
