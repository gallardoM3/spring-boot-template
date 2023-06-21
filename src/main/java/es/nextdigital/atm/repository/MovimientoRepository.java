package es.nextdigital.atm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Movimiento;
import es.nextdigital.enums.TipoMovimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

	Optional<List<Movimiento>> getMovimientosByIdCuentaAndTipoMovimiento(Long idCuenta, TipoMovimiento tipo) throws ATMException;
}
