package es.nextdigital.atm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Movimiento;
import es.nextdigital.atm.services.MovimientoService;
import es.nextdigital.enums.TipoMovimiento;

@RestController
@RequestMapping(value = "/atm" )
public class MovimientoController {
	
	protected static final String URL_MOVIMIENTOS = "/movimientos";
	
	@Autowired
	MovimientoService movimientoService;
	
	/**
	 * 
	 * @param idCuenta
	 * @param tipoMovimiento
	 * @return
	 * @throws ATMException
	 */
	@GetMapping(URL_MOVIMIENTOS + "/{idCuenta}")
	public Optional<List<Movimiento>> findMovimientoByIdCuentaAndTipoMovimiento(
			@PathVariable("idCuenta") Long idCuenta,
			@RequestBody TipoMovimiento tipoMovimiento) throws ATMException {
		return movimientoService.getMovimientosByIdCuentaAndTipoMovimiento(idCuenta, tipoMovimiento);

	}
}
