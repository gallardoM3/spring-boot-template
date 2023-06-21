package es.nextdigital.atm.services.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.atm.exceptions.ATMException;
import es.nextdigital.atm.model.Cuenta;
import es.nextdigital.atm.model.Tarjeta;
import es.nextdigital.atm.repository.CuentaRepository;
import es.nextdigital.atm.repository.MovimientoRepository;
import es.nextdigital.atm.services.CuentaService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	CuentaRepository cuentaRepository;

	@Autowired
	MovimientoRepository movimientosRepository;

	@Override
	public Optional<Cuenta> getCuenta(Long idCuenta) throws ATMException {
		return cuentaRepository.findById(idCuenta);
	}

	/**
	 * Sacar dinero solo de la cuenta a la que esté asociada la tarjeta que haya
	 * introducido en el cajero. Si la tarjeta es de débito, solo podrá sacar dinero
	 * si tiene saldo suficiente. Si la tarjeta es de crédito, podrá sacar también
	 * cuando no supere el máximo de crédito del que puede disponer. No podrá sacar
	 * dinero por encima del límite que tenga configurado para su tarjeta, sea de
	 * débito o de crédito. Si el cajero que está utilizando es de otro banco, se
	 * deberán tener en cuenta las comisiones que aplique esa entidad.
	 * @throws ATMException 
	 */
	@Override
	public Optional<Cuenta> sacarDineroFromCuenta(Long idCuenta, Tarjeta tarjeta, float importe) throws ATMException {
		Optional<Cuenta> cuenta = cuentaRepository.findById(idCuenta);
		float saldoActual = cuenta.get().getSaldo();
		
		if (cuenta.isEmpty()) {
			throw new ATMException(5000, "No existe la cuenta que quiere modificar");
		}
		
		// Si la tarjeta no esta activada se activará
		if(!tarjeta.isActivada()) {
			tarjeta.setActivada(true);
			tarjeta.setFechaCreacion(new Date());
		}

		// Si el nº de tarjeta es igual al de la cuenta sacacaré dinero
		if (idCuenta.equals(tarjeta.getCuenta().getIdCuenta())) {
			if("DEBITO".equals(tarjeta.getTipoTarjeta())){
				if(importe < saldoActual) {
					cuenta = cuentaRepository.sacarDineroFromCuenta(idCuenta, importe);
				}else {
					throw new ATMException(5001, "No tienes saldo suficiente");
				}
			}else if("CREDITO".equals(tarjeta.getTipoTarjeta())) {
				if(importe < saldoActual) {
					cuenta = cuentaRepository.sacarDineroFromCuenta(idCuenta, importe);
				}else {
					throw new ATMException(5002, "Has superado el máximo de crédito disponible");
				}
			}else {
				cuenta = cuentaRepository.sacarDineroFromCuenta(idCuenta, importe);				
			}
		}
		
		return cuenta;
	}

	@Override
	public Optional<Cuenta> ingresarDineroFromCuenta(Long idCuenta, Tarjeta tarjeta, float importe) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


}
