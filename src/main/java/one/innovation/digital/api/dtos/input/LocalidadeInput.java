package one.innovation.digital.api.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import one.innovation.digital.api.dtos.input.ids.NivelAcessoIdInput;

@Data
public class LocalidadeInput {

	@NotNull
	private NivelAcessoIdInput nivelAcesso;

	@NotBlank
	@Size(min = 3, max = 100)
	private String descricao;
}
