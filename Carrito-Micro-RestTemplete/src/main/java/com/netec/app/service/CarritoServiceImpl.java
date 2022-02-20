package com.netec.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.netec.app.entities.Carrito;
import com.netec.app.entities.Producto;

@Service
public class CarritoServiceImpl implements ICarritoService{
	@Autowired
	private Carrito carrito;
	
	@Autowired
	private RestTemplate rest;

	@Override
	public boolean addProducto(int id) {
	    Map<String, String> mapa=new HashMap<>();
	    mapa.put("id", String.valueOf(id));
	    String url="http://localhost:8092/productoid/{id}";
	    try {
	        Producto pr=rest.getForObject(url, Producto.class, mapa);
	        return carrito.getProductos().add(pr);
	    }catch(RestClientException ex) {
	    	return false;
	    }
	}

	@Override
	public boolean deleteProducto(int id) {
		Producto pr=carrito.getProductos()
				.stream().filter(t->t.getId()==id)
				.findFirst().orElse(null);
		return carrito.getProductos().remove(pr);
	}

	@Override
	public List<Producto> getAll() {
		return carrito.getProductos();
	}

	@Override
	public double getTotal() {
		
		return carrito.getTotal();
	}

}
