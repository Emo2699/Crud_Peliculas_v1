package entities.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pelicula {
    //Atributos

    private String nombre;
    private String genero;
    private String duracion;

    public Pelicula(){

    }

    public Pelicula(String nombre, String genero, String duracion){
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
    }

    //Metodos
    public boolean verificarDatos(){
        if(this.nombre.isEmpty() || this.nombre == null){
            System.out.println("El nombre de la peli no debe de ser vacio o nulo");
            return false;
        }
        if(this.genero.isEmpty() || this.genero == null){
            System.out.println("El genero de la peli no debe de ser vacio o nulo");
            return false;
        }
        if(this.duracion.isEmpty() || this.duracion == null){
            System.out.println("La duracion de la peli no debe de ser 0 o nulo");
            return false;
        }
        return true;
    }

    public String toString(){
        return this.nombre + " " + this.genero + " " +this.duracion +" ";
    }

}
