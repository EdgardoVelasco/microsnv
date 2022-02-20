package com.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.app.entities.Producto;
import com.netec.app.service.ICarritoService;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
	@Autowired
	private ICarritoService servicio;
	
	
	@GetMapping
	public List<Producto> getAll() {
		return servicio.getAll();
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProducto(@PathVariable("id") int id) {
		return servicio.deleteProducto(id);
	}
	
	@PutMapping("/{id}")
	public boolean addArticulo(@PathVariable("id") int id) {
		return servicio.addProducto(id);
	}
	
	@GetMapping("/total")
	public double getTotal() {
		return servicio.getTotal();
	}
}
