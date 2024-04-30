package entities.services;

import com.sun.security.jgss.GSSUtil;
import entities.model.Pelicula;
import entities.model.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorImpl implements IProveedor {


    @Override
    public boolean agregarPelicula(Proveedor proveedor, String titulo, String genero, String duracion){

        if(proveedor == null){
            System.out.println("El proveedor no existe...");
            return false;
        }

        if(titulo == null || genero == null || duracion == null){
            System.out.println("Error al agregar la pelicula...");
            return false;
        }else{
            Pelicula pelicula = new Pelicula(titulo, genero, duracion);
            proveedor.agregarPelicula(pelicula);
            return true;
        }
    }
    @Override
    public Pelicula buscarPelicula(Proveedor proveedor, String titulo){
        if(proveedor == null){
            System.out.println("El proveedor no existe...");
            return null;
        }

        Pelicula movie = proveedor.buscarPelicula(titulo);

        if(movie == null){
            System.out.println("La pelicula no existe dentro del catalogo del proveedor ");
            return null;
        }else{
            return movie;
        }

    }

    @Override
    public boolean eliminarPelicula(Proveedor proveedor, String titulo){
        if(proveedor == null){
            System.out.println("El proveedor no existe...");
            return false;
        }

        return proveedor.quitarPelicula(titulo);
    }


    @Override
    public boolean editarPelicula(Proveedor proveedor, Pelicula pelicula, String tituloNuevo, String generoNuevo, String duracionNueva){
        if(proveedor == null){
            System.out.println("El proveedor no existe.");
            return false;
        }

        return proveedor.actualizarPelicula(pelicula, tituloNuevo, generoNuevo, duracionNueva);
    }

    @Override
    public List<Pelicula> consultarPeliculas(Proveedor proveedor) {
        if(proveedor == null){
            return null;
        }else{
            return proveedor.getCatalogo();
        }
    }
}
