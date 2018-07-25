package br.com.felipedpl.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // habilito o servidor Eureka para resolver as requisicoes entre as instancias disponiveis de cada microservico
public class SpringBootEurekaNamingServer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaNamingServer.class, args);
	}
}
