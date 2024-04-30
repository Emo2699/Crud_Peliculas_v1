package com.example.cartelera;

import entities.BaseDatos;
import entities.model.Pelicula;
import entities.services.IProveedor;
import entities.services.ProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarteleraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarteleraApplication.class, args);
	}


	//Aqui inyeecto mi servicio
	//@Autowired
	//private IProveedor proveedorService;
	private ProveedorImpl servicio = new ProveedorImpl();
	private List<Pelicula> resultado;

	@Override
	public void run(String... args) throws Exception {
		/*Como en este ejercicio no hay conexion a base de datos, la persistencia de los
		* datos no existe realmente, por lo que se simulara creando un objeto "Base de datos"
		* el cual tiene una lista de proveedores, al iniciar la aplicacion.*/

		System.out.println("*****	Creando base de datos.... *****");
		BaseDatos bd = new BaseDatos();


		System.out.println("*****	Base de datos lista!	*****");

		Scanner teclado = new Scanner(System.in);
		boolean bandera = true;
		String opcion;

		String titulo;
		String genero;
		String duracion;

		//Al no tener endpoints de URL el controlador de la app es el siguiente menu
		//En esta parte del código estan los puntos que haran las peticiones a la app
		//desde el teclado, el menu es nuestro controlador.

		System.out.println("*****  Bienvenido a tu portal de peliculas  *****");
		do{

			System.out.println("Selecciona uno de nuestros proveedores para ver su catalogo:");
			System.out.println("1. Netflix");
			System.out.println("2. HBO MAX");
			System.out.println("3. Disney+");
			System.out.println("4. Salir");

			opcion = teclado.nextLine();

			switch(opcion){
				case "1":
					//Netflix
					System.out.println("		Bienvenido Netflix!!!	");

					boolean netflixFlag = true;
					do{
						System.out.println("		Selecciona la opcion que deseas realizar.	");
						System.out.println("		1. Agregar pelicula	");
						System.out.println("		2. Buscar pelicula	");
						System.out.println("		3. Editar pelicula	");
						System.out.println("		4. Eliminar pelicula	");
						System.out.println("		5. Ver Catalogo	");
						System.out.println("		6. Salir...	");

						opcion = teclado.nextLine();

						switch (opcion){
							case "1":
								System.out.println("		AGREGANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();
								System.out.println("		Ingresa el genero:	");
								genero = teclado.nextLine();
								System.out.println("		Ingresa la duracion en minutos:	");
								duracion = teclado.nextLine();

								this.servicio.agregarPelicula(bd.baseDatos.get(0),titulo,genero,duracion+" min");

								break;

							case "2":
								System.out.println("		BUSCANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();

								Pelicula res = this.servicio.buscarPelicula(bd.baseDatos.get(0),titulo);
								if(res != null){
									System.out.println("Pelicula encontrada!!");
									System.out.println("	-"+res.toString());
								}
								break;

							case "3":
								System.out.println("		EDITANDO PELICULA	");
								System.out.println("		Ingresa el titulo de la pelicula a editar:	");
								titulo = teclado.nextLine();

								//Primero buscamos que la pelicula a editar este en sistema
								Pelicula edicion = this.servicio.buscarPelicula(bd.baseDatos.get(0),titulo);

								if(edicion != null){
									System.out.println("		Ingresa el titulo nuevo:	");
									titulo = teclado.nextLine();
									System.out.println("		Ingresa el genero nuevo:	");
									genero = teclado.nextLine();
									System.out.println("		Ingresa la nueva duracion en minutos:	");
									duracion = teclado.nextLine();

									this.servicio.editarPelicula(bd.baseDatos.get(0),edicion,titulo,genero,duracion+" min");
								}
								break;

							case "4":
								System.out.println("		ELIMINANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();

								this.servicio.eliminarPelicula(bd.baseDatos.get(0),titulo);

								break;

							case "5":
								System.out.println("		CONSULTANDO PELICULAS	");
								//Utilizo mi servicio
								resultado = this.servicio.consultarPeliculas(bd.baseDatos.get(0));
								System.out.println("		Las peliculas son:		");
								for(Pelicula p: resultado){
									System.out.println("	-"+p.toString());
								}
								System.out.println();
								break;

							case "6":
								System.out.println("		Cerrando Sesion en Netflix ....");
								netflixFlag = false;
								break;

							default:
								System.out.println("		Opcion incorrecta, vuelve a elegir");
								break;
						}
					}while(netflixFlag);

					break;

				case "2":
					//HBO
					System.out.println("		Bienvenido HBO MAX!!!	");

					boolean hboFlag = true;
					do{
						System.out.println("		Selecciona la opcion que deseas realizar.	");
						System.out.println("		1. Agregar pelicula	");
						System.out.println("		2. Buscar pelicula	");
						System.out.println("		3. Editar pelicula	");
						System.out.println("		4. Eliminar pelicula	");
						System.out.println("		5. Ver Catalogo	");
						System.out.println("		6. Salir...	");

						opcion = teclado.nextLine();

						switch (opcion){
							case "1":
								System.out.println("		AGREGANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();
								System.out.println("		Ingresa el genero:	");
								genero = teclado.nextLine();
								System.out.println("		Ingresa la duracion en minutos:	");
								duracion = teclado.nextLine();

								this.servicio.agregarPelicula(bd.baseDatos.get(1),titulo,genero,duracion+" min");

								break;

							case "2":
								System.out.println("		BUSCANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();

								Pelicula res = this.servicio.buscarPelicula(bd.baseDatos.get(1),titulo);
								if(res != null){
									System.out.println("Pelicula encontrada!!");
									System.out.println("	-"+res.toString());
								}
								break;

							case "3":
								System.out.println("		EDITANDO PELICULA	");
								System.out.println("		Ingresa el titulo de la pelicula a editar:	");
								titulo = teclado.nextLine();

								//Primero buscamos que la pelicula a editar este en sistema
								Pelicula edicion = this.servicio.buscarPelicula(bd.baseDatos.get(1),titulo);

								if(edicion != null){
									System.out.println("		Ingresa el titulo nuevo:	");
									titulo = teclado.nextLine();
									System.out.println("		Ingresa el genero nuevo:	");
									genero = teclado.nextLine();
									System.out.println("		Ingresa la nueva duracion en minutos:	");
									duracion = teclado.nextLine();

									this.servicio.editarPelicula(bd.baseDatos.get(1),edicion,titulo,genero,duracion+" min");
								}
								break;

							case "4":
								System.out.println("		ELIMINANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();

								this.servicio.eliminarPelicula(bd.baseDatos.get(1),titulo);

								break;

							case "5":
								System.out.println("		CONSULTANDO PELICULAS	");
								//Utilizo mi servicio
								resultado = this.servicio.consultarPeliculas(bd.baseDatos.get(1));
								System.out.println("		Las peliculas son:		");
								for(Pelicula p: resultado){
									System.out.println("	-"+p.toString());
								}
								System.out.println();
								break;

							case "6":
								System.out.println("		Cerrando Sesion en HBO MAX ....");
								hboFlag = false;
								break;

							default:
								System.out.println("		Opcion incorrecta, vuelve a elegir");
								break;
						}
					}while(hboFlag);
					break;

				case "3":
					//Disney
					System.out.println("		Bienvenido Disney+!!!	");

					boolean disneyFlag = true;
					do{
						System.out.println("		Selecciona la opcion que deseas realizar.	");
						System.out.println("		1. Agregar pelicula	");
						System.out.println("		2. Buscar pelicula	");
						System.out.println("		3. Editar pelicula	");
						System.out.println("		4. Eliminar pelicula	");
						System.out.println("		5. Ver Catalogo	");
						System.out.println("		6. Salir...	");

						opcion = teclado.nextLine();

						switch (opcion){
							case "1":
								System.out.println("		AGREGANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();
								System.out.println("		Ingresa el genero:	");
								genero = teclado.nextLine();
								System.out.println("		Ingresa la duracion en minutos:	");
								duracion = teclado.nextLine();

								this.servicio.agregarPelicula(bd.baseDatos.get(2),titulo,genero,duracion+" min");

								break;

							case "2":
								System.out.println("		BUSCANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();

								Pelicula res = this.servicio.buscarPelicula(bd.baseDatos.get(2),titulo);
								if(res != null){
									System.out.println("Pelicula encontrada!!");
									System.out.println("	-"+res.toString());
								}
								break;

							case "3":
								System.out.println("		EDITANDO PELICULA	");
								System.out.println("		Ingresa el titulo de la pelicula a editar:	");
								titulo = teclado.nextLine();

								//Primero buscamos que la pelicula a editar este en sistema
								Pelicula edicion = this.servicio.buscarPelicula(bd.baseDatos.get(2),titulo);

								if(edicion != null){
									System.out.println("		Ingresa el titulo nuevo:	");
									titulo = teclado.nextLine();
									System.out.println("		Ingresa el genero nuevo:	");
									genero = teclado.nextLine();
									System.out.println("		Ingresa la nueva duracion en minutos:	");
									duracion = teclado.nextLine();

									this.servicio.editarPelicula(bd.baseDatos.get(2),edicion,titulo,genero,duracion+" min");
								}
								break;

							case "4":
								System.out.println("		ELIMINANDO PELICULA	");
								System.out.println("		Ingresa el titulo:	");
								titulo = teclado.nextLine();

								this.servicio.eliminarPelicula(bd.baseDatos.get(2),titulo);

								break;

							case "5":
								System.out.println("		CONSULTANDO PELICULAS	");
								//Utilizo mi servicio
								resultado = this.servicio.consultarPeliculas(bd.baseDatos.get(2));
								System.out.println("		Las peliculas son:		");
								for(Pelicula p: resultado){
									System.out.println("	-"+p.toString());
								}
								System.out.println();
								break;

							case "6":
								System.out.println("		Cerrando Sesion en Disney+ ....");
								disneyFlag = false;
								break;

							default:
								System.out.println("		Opcion incorrecta, vuelve a elegir");
								break;
						}
					}while(disneyFlag);

					break;

				case "4":
					System.out.println("Hasta pronto...");
					bandera=false;
					break;

				default:
					System.out.println("Opcion incorrecta, vuelve a elegir");
					break;
			}
		}while(bandera);

		teclado.close();

	}



}
