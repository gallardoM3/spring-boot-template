package es.nextdigital.enums;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Enumeración de los tipos de movimientos que habrá en una Cuenta
 * 
 * @author quality
 *
 */
@Data
@Entity
@Table(name="TipoMovimiento")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TipoMovimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;

	/**
	 * INGRESOS 
	 * INGRESO_SALDO, 
	 * DOMICILIACION_NOMINA, 
	 * TRANSFERENCIA_ENTRANTE, 
	 * //...
	 * //RETIRADA RETIRADA_SALDO, 
	 * DOMICILIACION_RECIBOS, 
	 * TRANSFERENCIA_SALIENTE
	 * //...
	 */
	private String desTipoMovimiento;

}
