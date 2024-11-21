package com.tienda.categoriasProductos.aplicacion.puerto.entrada;

import com.tienda.categoriasProductos.dominio.Categoria;
import com.tienda.exceptionHandler.excepciones.InvalidInputException;
import com.tienda.exceptionHandler.excepciones.ItemAlreadyExistException;
import com.tienda.exceptionHandler.excepciones.SearchItemNotFoundException;

import java.util.ArrayList;

public interface CategoriaPortIn {
    boolean crearCategoria(Categoria categoria)throws ItemAlreadyExistException, InvalidInputException;
    Categoria actualizarCategoria(Categoria categoria) throws SearchItemNotFoundException, InvalidInputException;
    Categoria obtenerCategoria(int id) throws SearchItemNotFoundException;
    boolean eliminarCategoria(int id) throws SearchItemNotFoundException;
    ArrayList<Categoria> consultarCategorias();
}
