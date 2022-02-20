package com.netec.app.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carrito")
public class Carrito {
	private List<Producto> productos;
	
	
	public Carrito() {
		this.productos= new ArrayList<>();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return this.productos.stream()
				.mapToDouble(t->t.getPrecio()).sum();
	}
	

}
