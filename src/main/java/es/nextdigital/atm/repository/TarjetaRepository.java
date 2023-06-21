package es.nextdigital.atm.repository;

import org.springframework.data.repository.CrudRepository;

import es.nextdigital.atm.model.Tarjeta;

public interface TarjetaRepository extends CrudRepository<Tarjeta, Long> {

}
