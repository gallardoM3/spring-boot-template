package es.nextdigital.atm.services;

import java.util.List;
import java.util.Optional;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Movimiento;
import es.nextdigital.enums.TipoMovimiento;

public interface MovimientoService {

	Optional<List<Movimiento>> getMovimientosByIdCuentaAndTipoMovimiento(Long idCuenta, TipoMovimiento tipoMovimiento)
			throws ATMException;

}
