package es.nextdigital.atm.model;

import java.util.Date;
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
 * La tarjeta pertenece a un Cliente, tiene n movimientos y una cuenta asociada
 * @author quality
 *
 */
@Data
@Entity
@Table(name="Tarjeta")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tarjeta {

	private Long idTarjeta;
	
	private String numeroTarjeta;
	
	private String codigoTarjeta;
	
	//Hubiera hecho un enum o algo pero no me da tiempo
	private String tipoTarjeta;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCliente")
	private Cliente titular;
	
	private Double saldo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idMovimiento")
	private List<Movimiento> movimientos;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCuienta")
	private Cuenta cuenta;
	
	private Date fechaCreacion;
	
	private Date fechaBaja;
	
	private boolean activada;
	
}
