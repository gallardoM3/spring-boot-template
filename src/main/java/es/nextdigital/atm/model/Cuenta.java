package es.nextdigital.atm.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * La clase Cuenta tiene un cliente asociadado, n movimientos y n tarjetas.
 * @author quality
 *
 */
@Data
@Entity
@Table(name="Cuenta")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cuenta {
	private Long idCuenta;
	
	private String numeroCuenta;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCliente")
	private Cliente titular;
	
	private float saldo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idMovimiento")
	private List<Movimiento> movimientos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTarjeta")
	private List<Tarjeta> tarjetas;
	
	private LocalDateTime fechaCreacion;
	
	private LocalDateTime fechaBaja;
	
}
