package es.nextdigital.atm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Movimiento;
import es.nextdigital.atm.repository.CuentaRepository;
import es.nextdigital.atm.repository.MovimientoRepository;
import es.nextdigital.atm.services.MovimientoService;
import es.nextdigital.enums.TipoMovimiento;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	CuentaRepository cuentaRepository;
	
	@Autowired
	MovimientoRepository movimientosRepository;
	
	
	@Override
	public Optional<List<Movimiento>> getMovimientosByIdCuentaAndTipoMovimiento(Long idCuenta, TipoMovimiento tipo) throws ATMException {
		return movimientosRepository.getMovimientosByIdCuentaAndTipoMovimiento(idCuenta, tipo);
	}

}
