package br.com.felipedpl.microservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.felipedpl.microservice.bean.CurrencyConverterBean;

// Informo as configuraçoes do servico que vou acessar e crio um proxy para a chamada de url desejada 
@FeignClient(name="forex-service")
// Balanceador de carga entre as instancias (portas) de servico configurada no arquivo de propriedades (evita hardcoded de url na interface de proxy)
@RibbonClient(name="forex-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConverterBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
