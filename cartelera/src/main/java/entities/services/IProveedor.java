package entities.services;

import entities.model.Pelicula;
import entities.model.Proveedor;

import java.util.List;

public interface IProveedor {

    boolean agregarPelicula(Proveedor proveedor, String titulo, String genero, String duracion);

    Pelicula buscarPelicula(Proveedor proveedor, String titulo);


    boolean eliminarPelicula(Proveedor proveedor, String titulo);

    boolean editarPelicula(Proveedor proveedor, Pelicula pelicula, String tituloNuevo, String generoNuevo, String duracionNueva);

    List<Pelicula> consultarPeliculas(Proveedor proveedor);
}
