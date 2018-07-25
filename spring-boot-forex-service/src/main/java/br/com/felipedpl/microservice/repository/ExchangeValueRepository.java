package br.com.felipedpl.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipedpl.microservice.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo (String from, String to);
}
