package com.tienda.administracion.adaptador.puerto.entrada;

import com.tienda.administracion.adaptador.modelo.AdministradorControllerModel;
import com.tienda.administracion.aplicacion.puerto.entrada.PuertoEntradaAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private PuertoEntradaAdmin service;
    private final MapperControllerToDomainAdmin mapper;

    @Autowired
    public AdminController(PuertoEntradaAdmin service, MapperControllerToDomainAdmin mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<AdministradorControllerModel>> obtenerAdministradores(){
        ArrayList<AdministradorControllerModel> response=new ArrayList<>();
        service.obtenerAdmins().forEach((i)->{response.add(mapper.toControllerModel(i));});
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
