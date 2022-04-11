package puntoventa;

import java.util.ArrayList;
import java.util.List;

public class Carro {

	static List<Producto> carrito = new ArrayList<Producto>();
	


	public static List<Producto> getCarrito() {
		return carrito;
	}

	public static void vaciarCarro() {
		carrito.clear();
	}
	
	public static void agregarProducto(Producto unidad ) {
		carrito.add(unidad);
	}
	
	public static int sumaUnidad() {
		int total = 0;
		for(Producto unidad:carrito) {
			total += unidad.getPrecio(); 			
		}
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
}
