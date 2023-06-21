package es.nextdigital.atm.repository;

import org.springframework.data.repository.CrudRepository;

import es.nextdigital.atm.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
