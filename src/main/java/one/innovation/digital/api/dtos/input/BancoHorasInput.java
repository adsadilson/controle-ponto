package one.innovation.digital.api.dtos.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;
import one.innovation.digital.api.dtos.input.ids.MovimentacaoIdInput;
import one.innovation.digital.api.dtos.input.ids.UsuarioIdInput;

@Data
public class BancoHorasInput {

	@NotNull
	private MovimentacaoIdInput movto;
	
	@NotNull
	private UsuarioIdInput usuario;
	
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHoras;
	private BigDecimal saldoHoras;

}
