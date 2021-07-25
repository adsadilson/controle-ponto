package one.innovation.digital.api.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoriaUsuarioInput {

	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;

	private String descricao;
	
}
