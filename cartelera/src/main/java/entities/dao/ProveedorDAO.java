package entities.dao;

import entities.model.Pelicula;
import entities.model.Proveedor;

import java.util.List;

public interface ProveedorDAO {
    List<Pelicula> consultarCatalogo(Proveedor proveedor);
}
