package one.innovation.digital.api.dtos.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;
import one.innovation.digital.api.dtos.input.ids.CalendarioIdInput;
import one.innovation.digital.api.dtos.input.ids.OcorrenciaIdInput;
import one.innovation.digital.api.dtos.input.ids.UsuarioIdInput;

@Data
public class MovimentacaoInput {

	@NotNull
	private UsuarioIdInput usuario;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	private OcorrenciaIdInput ocorrencia;
	private CalendarioIdInput calendario;
}
