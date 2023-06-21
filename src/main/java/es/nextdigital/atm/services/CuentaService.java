package es.nextdigital.atm.services;

import java.util.Optional;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Cuenta;
import es.nextdigital.atm.model.Tarjeta;

public interface CuentaService {

	Optional<Cuenta> getCuenta(Long idCuenta) throws ATMException;

	Optional<Cuenta> sacarDineroFromCuenta(Long idCuenta, Tarjeta tarjeta, float importe) throws ATMException;

	Optional<Cuenta> ingresarDineroFromCuenta(Long idCuenta, Tarjeta tarjeta, float importe);
}
