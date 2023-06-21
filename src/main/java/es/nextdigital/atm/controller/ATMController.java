package es.nextdigital.atm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iberdrola.tot.exception.TOTException;
import com.iberdrola.tot.model.Revision;
import com.iberdrola.tot.model.Usuario;
import com.iberdrola.tot.utilidades.Constantes;
import com.iberdrola.tot.utilidades.ExcelUtils;


@RestController
@RequestMapping(value = "/atm" )
public class ATMController {
	
	/**
	 * Permite descargar una revision de un usuario.
	 *
	 * @param session
	 * @return
	 * @throws TOTException
	 * @throws IOException
	 */
	@GetMapping("/movimientos/{}")
	public ResponseEntity<byte[]> descargarRevision(HttpSession session, HttpServletResponse response,
			@RequestBody Revision revision) throws TOTException, IOException {
		XSSFWorkbook wb;

		Usuario usuario = (Usuario) session.getAttribute(Constantes.USUARIO_TOT);
		LOG.info(usuarioSesion, usuario);
		wb = revisionService.descargarRevision(usuario.getNumExpediente(), revision);
		return ExcelUtils.responseExcel(response, wb);

	}
}
