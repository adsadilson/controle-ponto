package one.innovation.digital.api.dtos.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import one.innovation.digital.api.dtos.input.ids.CategoriaUsuarioIdInput;
import one.innovation.digital.api.dtos.input.ids.EmpresaIdInput;
import one.innovation.digital.api.dtos.input.ids.JornadaTrabalhoIdInput;
import one.innovation.digital.api.dtos.input.ids.NivelAcessoIdInput;

@Data
public class UsuarioInput {

	@NotNull
	private CategoriaUsuarioIdInput categoriaUsuario;

	@NotBlank
	@Size(min = 3, max = 80)
	private String nome;

	@NotNull
	private EmpresaIdInput empresa;

	@NotNull
	private NivelAcessoIdInput nivelAcesso;

	@NotNull
	private JornadaTrabalhoIdInput jornadaTrabalho;

	private BigDecimal tolerancia;

	private LocalDateTime inicioJornada;

	private LocalDateTime finalJornada;
}
