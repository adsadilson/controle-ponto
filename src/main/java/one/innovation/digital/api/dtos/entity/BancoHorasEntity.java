package one.innovation.digital.api.dtos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BancoHorasEntity {

	private Long id;
	private MovimentacaoEntity movto;
	private UsuarioEntity usuario;
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHoras;
	private BigDecimal saldoHoras;

}
