package com.tienda.publicaciones.adaptador.puerto.salida;

import com.tienda.publicaciones.adaptador.modelo.PublicacionPersistenceModel;
import com.tienda.publicaciones.dominio.Publicacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapperRepositoryToDomainPublicacion {
    @Mappings({
            @Mapping(source = "idPublicacion",target = "id"),
            @Mapping(source = "tituloPublicacion",target = "tituloPublicacion"),
            @Mapping(source = "descripcion",target = "descripcion"),
            @Mapping(source = "precio",target = "precio"),
            @Mapping(source = "categoria",target = "categoria"),
            @Mapping(source = "cantidadDisponible",target = "cantidadDisponible"),
            @Mapping(source = "fechaPublicacion",target = "fechaPublicacion"),
            @Mapping(source = "usuario",target = "usuario")
    })
    Publicacion toDomainModel(PublicacionPersistenceModel persistenceModel);
    @InheritInverseConfiguration
    PublicacionPersistenceModel toPersistenceModel(Publicacion domainModel);
}
