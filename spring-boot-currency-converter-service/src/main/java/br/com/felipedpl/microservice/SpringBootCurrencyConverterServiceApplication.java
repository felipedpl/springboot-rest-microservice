package br.com.felipedpl.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("br.com.felipedpl.microservice.proxy") // habilito o proxy e informo qual pacote que terei os client proxies
@EnableDiscoveryClient
public class SpringBootCurrencyConverterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurrencyConverterServiceApplication.class, args);
	}
}
