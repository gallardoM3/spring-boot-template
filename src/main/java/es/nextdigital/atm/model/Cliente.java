package es.nextdigital.atm.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Clase Cliente tiene n cuentas asocidadas
 * @author quality
 *
 */
@Data
@Entity
@Table(name="Cliente")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	private String nombre;

	private String apellido1;
	
	private String apellido2;

	private String edad;

	private String domicilio;
	
	private String telefono;
	
	private String email;
	
	private String dni;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCuenta")
	private List<Cuenta> listaCuentas;
}
