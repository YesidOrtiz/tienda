package com.tienda.administracion.adaptador.puerto.salida;

import com.tienda.administracion.adaptador.modelo.AdministradorPersistenceModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<AdministradorPersistenceModel,Integer> {
}
