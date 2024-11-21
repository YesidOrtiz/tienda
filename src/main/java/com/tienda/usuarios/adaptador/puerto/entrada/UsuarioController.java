package com.tienda.usuarios.adaptador.puerto.entrada;

import com.tienda.exceptionHandler.excepciones.InvalidInputException;
import com.tienda.usuarios.adaptador.modelo.CrearUsuario_ControllerModel;
import com.tienda.usuarios.adaptador.modelo.UsuarioBasicData;
import com.tienda.usuarios.aplicacion.puerto.entrada.CasoUsoCrearUsuario;
import com.tienda.usuarios.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CasoUsoCrearUsuario serviceCrearUsuario;
    private final MapperControllerToDomainUsuario_CrearUsuario mapper;
    private final MapperDomainUsuarioToUsuarioBasicData mapperBasicData;

    @Autowired
    public UsuarioController(CasoUsoCrearUsuario serviceCrearUsuario,MapperControllerToDomainUsuario_CrearUsuario mapper,MapperDomainUsuarioToUsuarioBasicData mapperBasicData) {
        this.serviceCrearUsuario = serviceCrearUsuario;
        this.mapper=mapper;
        this.mapperBasicData=mapperBasicData;
    }
    @GetMapping("/nuevousuario")
    public ResponseEntity<UsuarioBasicData> crearUsuario(CrearUsuario_ControllerModel user) throws InvalidInputException {
        UsuarioBasicData response=mapperBasicData.toBasicDataModel(serviceCrearUsuario.crearUsuario(mapper.toDomainModel(user)));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
