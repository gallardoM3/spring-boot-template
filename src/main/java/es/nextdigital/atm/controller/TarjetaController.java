package es.nextdigital.atm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Cuenta;
import es.nextdigital.atm.services.CuentaService;


@RestController
@RequestMapping(value = "/tarjeta" )
public class TarjetaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping("/{idTarjeta}")
	public Optional<Cuenta> findMovimientoByIdCuentaAndTipoMovimiento(
			@PathVariable("idCuenta") Long idCuenta) throws ATMException {
		return cuentaService.getCuenta(idCuenta);

	}
}