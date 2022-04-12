package puntoventa;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class PuntoVenta {
	
	
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	//final convierte una variable en constantes, solo para lectura de datos
	
	public final static int OPCION_MENU_SALIR = 6;//listo
	public final static int OPCION_MENU_PAGAR = 5;//falta
	public final static int OPCION_MENU_CARRO = 4;//falta
	public final static int OPCION_MENU_ELIMINAR = 3;//listo
	public final static int OPCION_MENU_PRODUCTOS = 2;//listo
	public final static int OPCION_MENU_CREAR = 1;//listo

	public static void main(String[] args) {
		int opcionSeleccionada;
		do {
			opcionSeleccionada = menu();
			switch( opcionSeleccionada ) {
			case OPCION_MENU_CREAR:
				crearProducto();
				break;
			case OPCION_MENU_PRODUCTOS:
				verProducto();
				break;
			case OPCION_MENU_ELIMINAR:
				eliminarProducto();
				break;
			case OPCION_MENU_CARRO:
				agregarProducto();
				break;
			case OPCION_MENU_PAGAR:
				pagar();
				break;
			}
		} while( opcionSeleccionada != OPCION_MENU_SALIR );
		
		
		System.out.printf("Hasta luego que tenga un buen día! :)");
	}
	
	
	private static void agregarProducto() { 
		int llave = 0;
		
		System.out.println("Productos disponibles para comprar:\n");
		
			for(Producto unidad:productos) {
			System.out.printf("Producto: %s Precio: $%d%n",unidad.getNombre(),unidad.getPrecio());
		}
		
			do{
				System.out.println("Ingresa el nombre del producto que deseas agregar:\n");
				Scanner teclado = new Scanner( System.in);
				String unidad = teclado.nextLine();
				
				for(int i = 0;i<productos.size();i++) {
					if(productos.get(i).getNombre().equals(unidad)) {
						Producto uni = productos.get(i);
						System.out.printf("=>El producto %s, fue agregado exitosamente <=\n", uni);
						Carro.agregarProducto(uni);
						llave = 1;
						break;
					}else {
						System.out.println("Debe ingresar un producto disponible en la lista\n");//consultar por la repeticion de mensaje****************(break probado)
						llave = 0;
						continue;
					}
				}
		
		}while(llave != 1);
		
		System.out.println(Carro.getCarrito());
		
		
		
	}
	
	
	private static void pagar() {
		int total = Carro.sumaUnidad();
		
		System.out.printf("La cantidad a pagar es: => $%d pesos.\n\n", total);
	}


	private static void eliminarProducto() {
		
		System.out.println("\nEstos son los productos disponibles actualmente:\n");
		for( Producto producto : productos ){
			System.out.printf("Codigo: %s Producto: %s Precio: %d %n"
					, producto.getCodigo()
					, producto.getNombre()
					, producto.getPrecio()
					);
		}
		
		System.out.println("\nSeleccione el código que desea eliminar de la lista:\n");
		Scanner teclado = new Scanner( System.in );
		String eliminarCodigo = teclado.nextLine();
		
		for(int i = 0;i<productos.size();i++) {
			if(productos.get(i).getCodigo().equals(eliminarCodigo)) {
				productos.remove(i);
				System.out.println("Se elimino el producto con codigo: " + eliminarCodigo);
				break;
			}
		}	
	}

	private static void verProducto() {
		// TODO Auto-generated method stub
		System.out.println("Lista de productos creados:\n");
		for( Producto producto : productos ){
			System.out.printf("Codigo: %s Producto: %s Precio: %d %n"
					, producto.getCodigo()
					, producto.getNombre()
					, producto.getPrecio()
					);
		}
		System.out.println("\n");
		
	}

	private static void crearProducto() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner( System.in );
		
		System.out.println("Por favor ingrese un codigo para su producto: ");
		String codigoProducto = scanner.nextLine();
		
		System.out.println("Por favor ingrese un nombre para su producto: ");
		String nombreProducto = scanner.nextLine();
		
		System.out.println("Por favor ingrese un precio para su producto: ");
		int precioProducto = scanner.nextInt();
		
		Producto productoNuevo = new Producto(codigoProducto, nombreProducto, precioProducto);
		productos.add(productoNuevo);
	}

	private static int menu() {
		System.out.println("Menu punto de venta");
		System.out.println("1. Crear Producto");
		System.out.println("2. Ver Productos");
		System.out.println("3. Eliminar Producto");
		System.out.println("4. Agregar Producto al carro");
		System.out.println("5. Pagar");
		System.out.println("6. SALIR");
		
		System.out.println("\nPor favor digita tu opcion: ");
		Scanner scanner = new Scanner(System.in);
		int opcionSeleccionada = scanner.nextInt();
		return opcionSeleccionada;
	}

}
