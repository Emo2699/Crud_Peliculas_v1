package entities.dao;

import entities.model.Pelicula;
import entities.model.Proveedor;

import java.util.List;

public class ProveedorDAOImpl implements ProveedorDAO{
    @Override
    public List<Pelicula> consultarCatalogo(Proveedor proveedor) {
        if(proveedor == null){
            System.out.println("El proveedor no existe...");
            return null;
        }else{
            return proveedor.getCatalogo();
        }

    }
}
