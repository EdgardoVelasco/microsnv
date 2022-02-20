package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Producto;

public interface ICarritoService {
	List<Producto> getAll();
	boolean deleteProducto(int id);
	boolean addProducto(int id);
	double getTotal();

}
