package br.com.felipedpl.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipedpl.microservice.model.ExchangeValue;
import br.com.felipedpl.microservice.repository.ExchangeValueRepository;

@RestController
@RequestMapping("/currency-exchange")
public class ForexController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue (@PathVariable("from") String from, @PathVariable("to") String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue; //response bean
	}
}
