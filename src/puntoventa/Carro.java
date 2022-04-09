package puntoventa;

import java.util.ArrayList;
import java.util.List;

public class Carro {

	List<Producto> carrito = new ArrayList<Producto>();
	

	public Carro() {
	}

	public Carro(List<Producto> carrito) {
		this.carrito = carrito;
	}

	public List<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}
	
	public void agregarProducto(Producto unidad ) {
		this.carrito.add(unidad);
	}
	
	//agregar otro metodo,
	
	
	
	
	
	
	
	
}
