package com.netec.app.filters;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class EjemploFiltro implements GlobalFilter{
	private final Logger logger=LoggerFactory.getLogger(EjemploFiltro.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Ejecutando el Filtro PRE");
		/*Todo lo que agreguemos aqui se ejecuta en el PREFilter*/
		/*Por defecto el request es immutable*/
		/*agregamos un header al Request*/
		exchange.getRequest().mutate()
		.headers(x->x.add("token", "1234"));
		
		
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			logger.info("Ejecutando el Filtro POST");
			/*Todo lo que agregamos aqui se ejecuta en el POSTFilter*/
			exchange.getResponse().getCookies().add("nombre", 
					ResponseCookie.from("nombre", "edgardo").build());
			
			exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
			
			/*El token que recibe el PREFilter lo enviamos
			 * a nuestro Response, pero validamos que exista*/
			Optional.ofNullable(exchange.getRequest()
					.getHeaders().getFirst("token"))
			.ifPresent(token-> {
				exchange.getResponse().getHeaders().add("token", token);
			});
		}));
	}

}
