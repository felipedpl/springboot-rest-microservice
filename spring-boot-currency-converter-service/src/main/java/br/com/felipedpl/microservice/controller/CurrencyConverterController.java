package br.com.felipedpl.microservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipedpl.microservice.bean.CurrencyConverterBean;
import br.com.felipedpl.microservice.proxy.CurrencyExchangeServiceProxy;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConverterController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterBean retrieveCurrencyConverted (@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		
/*		// Faço a requisição para o outro serviço passando os parametros necessarios de url
		Map<String,String> uri = new HashMap<>();
		uri.put("from", from);
		uri.put("to", to);
		
		ResponseEntity<CurrencyConverterBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverterBean.class, uri);
		CurrencyConverterBean bean = responseEntity.getBody();*/
		// Agora faço a chamada direto pelo proxy, evitando o hardcoded da url nos controllers
		CurrencyConverterBean bean = proxy.retrieveExchangeValue(from, to);
		System.out.println(bean);
		return new CurrencyConverterBean(bean.getId(), from, to, bean.getConversionMultiple(), quantity, quantity.multiply(bean.getConversionMultiple()), bean.getPort());
	}
}
