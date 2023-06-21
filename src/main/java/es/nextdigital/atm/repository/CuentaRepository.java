package es.nextdigital.atm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
	Optional<Cuenta> sacarDinero(Long idCuenta, Float importe) throws ATMException;
	
	Optional<Cuenta> ingresarDinero(Long idCuenta, Float importe) throws ATMException;
}
