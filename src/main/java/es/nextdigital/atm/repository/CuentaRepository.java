package es.nextdigital.atm.repository;

import org.springframework.data.repository.CrudRepository;

import es.nextdigital.atm.model.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

}
