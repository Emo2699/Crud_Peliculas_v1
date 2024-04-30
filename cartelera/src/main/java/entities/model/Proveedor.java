package entities.model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {

    private String nombre;

    private List<Pelicula> catalogo = new ArrayList<>();

    //Constructor
    public Proveedor(String nombre){
        this.nombre = nombre;
    }


    public String getNombre(){
        return this.nombre;
    }

    public List<Pelicula> getCatalogo(){
        return this.catalogo;
    }

    //Metodos


    public void agregarPelicula(Pelicula pelicula){
        if(!pelicula.verificarDatos()){
            System.out.println("Error al agregar pelicula a la cartelera");
        }else{
            this.catalogo.add(pelicula);
            System.out.println("Pelicula agregada correctamente");

        }
    }

    public void agregarPelicula(String nombre, String genero, String duracion){
        if(nombre.isEmpty() || nombre == null || genero.isEmpty() || genero == null || duracion.isEmpty() || duracion == null){
            System.out.println("Error al agregar pelicula a la cartelera...");
        }else{
            Pelicula movie = new Pelicula(nombre, genero, duracion);
            this.catalogo.add(movie);
            System.out.println("Pelicula agregada correctamente");
        }
    }

    public Pelicula buscarPelicula(String titulo){
        if(titulo == null || titulo.isEmpty()){
            System.out.println("La pelicula no existe");
            return null;
        }

        for(Pelicula movie: catalogo){
            if(movie.getNombre().equalsIgnoreCase(titulo)){
                return movie;
            }
        }
        System.out.println("La pelicula no existe");
        return null;
    }


    public boolean actualizarPelicula(Pelicula pelicula, String tituloNuevo, String generoNuevo, String duracionNueva){
        if(pelicula == null){
            System.out.println("La pelicula no existe");
            return false;
        }

        int indice = this.catalogo.indexOf(pelicula);

        if(indice != -1){
            //Creamos un nuevo objeto
            Pelicula actualizada = new Pelicula(tituloNuevo,generoNuevo,duracionNueva);

            //Actualizamos en la lista
            this.catalogo.set(indice,actualizada);
            System.out.println("La pelicula se ha actualizado correctamente...");
            return true;
        }else{
            System.out.println("La pelicula no existe en sistema");
            return false;
        }
    }


    public boolean quitarPelicula(String titulo){
        try{
            Pelicula movie = buscarPelicula(titulo);

            if(movie == null){
                System.out.println("Error al eliminar la pelicula...");
                return false;
            }else{
                this.catalogo.remove(movie);
                System.out.println("Se elimino la pelicula correctamente...");
                return true;
            }
        }catch(Exception e){
            System.out.println("Error al eliminar la pelicula...");
            return false;
        }
    }

}
