package one.innovation.digital.api.dtos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MovimentacaoEntity {

	private Long id;
	private UsuarioEntity usuario;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	private OcorrenciaEntity ocorrencia;
	private CalendarioEntity calendario;
}
