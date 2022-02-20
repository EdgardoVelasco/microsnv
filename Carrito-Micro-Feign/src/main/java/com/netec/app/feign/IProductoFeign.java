package com.netec.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netec.app.entities.Producto;

//@FeignClient(name="micro-producto", url="http://localhost:8092")
@FeignClient(name="micro-producto")
public interface IProductoFeign {
	
	@GetMapping("/productoid/{id}")
	public Producto findById(@PathVariable("id") int id);

}
