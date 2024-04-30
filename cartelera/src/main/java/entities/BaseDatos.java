package entities;

/*Esta clase funcionara para simular una BD, aqui los datos se almacenaran en una lista
* de proveedores, por lo que cuando se inicie la aplicacion un objeto de esta clase debe de
* instanciarse.*/


import entities.model.Pelicula;
import entities.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    //Atributos
    public List<Proveedor> baseDatos = new ArrayList<>();

    public BaseDatos(){
        //En este constructor ya se debe de llenar el arreglo baseDatos para que tenga
        //info y pueda ser consultada
        Proveedor netflix = new Proveedor("Netflix");
        Proveedor hbo = new Proveedor("HBO MAX");
        Proveedor disney = new Proveedor("Disney+");

        //Agrego peliculas a cada proveedor
        //Netflix
        Pelicula n1 = new Pelicula("Son como niños 2", "comedia", "101 min");
        Pelicula n2 = new Pelicula("No Manches frida", "comedia", "116 min");
        Pelicula n3 = new Pelicula("Sherek", "infantil", "90 min");
        netflix.agregarPelicula(n1);
        netflix.agregarPelicula(n2);
        netflix.agregarPelicula(n3);

        //HBO

        Pelicula h1 = new Pelicula("El señor de los anillos La comunidad del anillo", "fantasia", "178 min");
        Pelicula h2 = new Pelicula("Harry Potter y la piedra filosofal", "fantasia ", "152 min");
        Pelicula h3 = new Pelicula("Gran Turismo: De jugador a corredor", "Deportes", "134 min");
        hbo.agregarPelicula(h1);
        hbo.agregarPelicula(h2);
        hbo.agregarPelicula(h3);

        //Disney

        Pelicula d1 = new Pelicula("Las Cronicas de Narnia El Leon la Bruja y el Ropero", "fantasia", "149 min");
        Pelicula d2 = new Pelicula("El Rey Leon", "infantil", "88 min");
        Pelicula d3 = new Pelicula("Avengers End Game", "accion", "182 min");
        disney.agregarPelicula(d1);
        disney.agregarPelicula(d2);
        disney.agregarPelicula(d3);

        //Teniendo los proveedores con datos los agrego a la lista de proveedores
        this.baseDatos.add(netflix);
        this.baseDatos.add(hbo);
        this.baseDatos.add(disney);

    }


}
