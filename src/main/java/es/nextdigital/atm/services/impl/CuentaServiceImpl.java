package es.nextdigital.atm.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Cuenta;
import es.nextdigital.atm.repository.CuentaRepository;
import es.nextdigital.atm.repository.MovimientoRepository;
import es.nextdigital.atm.services.CuentaService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	CuentaRepository cuentaRepository;
	
	@Autowired
	MovimientoRepository movimientosRepository;
	
	
	@Override
	public Optional<Cuenta> getCuenta(Long idCuenta) throws ATMException {
		return cuentaRepository.findById(idCuenta);
	}

}
