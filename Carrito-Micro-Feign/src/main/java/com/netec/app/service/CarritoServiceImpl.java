package com.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.app.entities.Carrito;
import com.netec.app.entities.Producto;
import com.netec.app.feign.IProductoFeign;

import feign.FeignException;

@Service
public class CarritoServiceImpl implements ICarritoService {
	@Autowired
	private Carrito carrito;
	@Autowired
	private IProductoFeign feign;

	@Override
	public List<Producto> getAll() {
		return carrito.getProductos();
	}

	@Override
	public boolean deleteProducto(int id) {
		Producto pr= carrito.getProductos().stream()
				.filter(t->t.getId()==id)
				.findFirst().get();

		return carrito.getProductos().remove(pr);
	}

	@Override
	public boolean addProducto(int id) {
		try {
		   Producto pr = feign.findById(id);
		   return carrito.getProductos().add(pr);
		}catch(FeignException ex) {
			return false;
		}
	}

	@Override
	public double getTotal() {
	   return carrito.getTotal();
	}

}
