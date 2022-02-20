package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Producto;

public interface ICarritoService {
	boolean addProducto(int id);
	boolean deleteProducto(int id);
	List<Producto> getAll();
	double getTotal();
}
