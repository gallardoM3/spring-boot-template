package es.nextdigital.atm.services;

import java.util.Optional;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Cuenta;

public interface CuentaService {

	Optional<Cuenta> getCuenta(Long idCuenta) throws ATMException;
}
