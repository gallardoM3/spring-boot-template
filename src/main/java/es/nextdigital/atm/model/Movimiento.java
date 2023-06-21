package es.nextdigital.atm.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.nextdigital.enums.TipoMovimiento;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Clase Movimiento tiene n tipos de movimientos
 * 
 * @author quality
 *
 */
@Data
@Entity
@Table(name="Movimiento")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movimiento {
	/**
	 * Id del movimiento
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;
	
	private String descripcion;
	
	private LocalDateTime fechaMovimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMovimiento")
	@JsonProperty("tipoTarea")
	private TipoMovimiento tipoMovimiento;
	
	private Double cantidad;

	private String categoria;
}
