package com.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.app.entities.Producto;
import com.netec.app.service.ICarritoService;

@RestController
public class CarritoController {
	@Autowired
	private ICarritoService servicio;
	
	@GetMapping("/carrito")
	public List<Producto> getAll(){
		return servicio.getAll();
	}
	
	@PutMapping("/carrito/{idArt}")
	public boolean insertArticulo(@PathVariable("idArt") int id) {
		return servicio.addProducto(id);
	}
	
	@DeleteMapping("/carritod/{idArt}")
	public boolean deleteArticulo(@PathVariable("idArt") int id) {
		return servicio.deleteProducto(id);
	}
	
	@GetMapping("/carritot")
	public double total() {
		return servicio.getTotal();
	}
	
}
