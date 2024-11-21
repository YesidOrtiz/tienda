package com.tienda.administracion.adaptador.puerto.entrada;

import com.tienda.administracion.adaptador.modelo.AdministradorControllerModel;
import com.tienda.administracion.adaptador.modelo.IdRequest;
import com.tienda.administracion.aplicacion.puerto.entrada.PuertoEntradaAdmin;
import com.tienda.administracion.dominio.Administrador;
import com.tienda.exceptionHandler.excepciones.InvalidInputException;
import com.tienda.exceptionHandler.excepciones.ItemAlreadyExistException;
import com.tienda.exceptionHandler.excepciones.SearchItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/registro")
    public ResponseEntity<AdministradorControllerModel> registrarNuevoAdministrador(Administrador admin) throws InvalidInputException, ItemAlreadyExistException {
        AdministradorControllerModel response=mapper.toControllerModel(service.registrarAdmin(admin));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<AdministradorControllerModel> actualizarAdministrador(Administrador admin) throws InvalidInputException, SearchItemNotFoundException {
        AdministradorControllerModel response=mapper.toControllerModel(service.actualizarAdmin(admin));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarAdministrador(@RequestBody IdRequest idRequest) throws SearchItemNotFoundException {
        service.eliminarAdminPorId(idRequest.getId());
        return ResponseEntity.ok().build();
    }
}
