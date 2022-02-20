package com.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.app.dao.IProductoDAO;
import com.netec.app.entities.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
	private IProductoDAO dao;
    
    @Value("${server.port}")
    private int port;

	
	@Override
	public List<Producto> findAll() {
		
		return (List<Producto>)dao.findAll() ;
	}

	@Override
	public Producto save(Producto pr) {
		
		return dao.save(pr);
	}

	@Override
	public boolean update(Producto pr) {
		if(dao.existsById(pr.getId())) {
			dao.save(pr);
			return true;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
	}

	@Override
	public void deleteById(int id) {
		 if(dao.existsById(id)) {
			 dao.deleteById(id);
			 return;
          }
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
	}

	@Override
	public Producto findByName(String name) {
		
		return dao.findByName(name)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
	}

	@Override
	public Producto findById(int id) {
		return dao.findById(id)
				.stream()
				.filter(t->t!=null).peek(t->t.setPort(port))
				.findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
				
				
	}

	
}
