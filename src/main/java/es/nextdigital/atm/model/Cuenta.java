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
	
	private Double saldo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idMovimiento")
	private List<Movimiento> movimientos;
	
	private LocalDateTime fechaCreacion;
	
	private LocalDateTime fechaBaja;
	
}
