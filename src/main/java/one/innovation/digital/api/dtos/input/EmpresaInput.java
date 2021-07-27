package one.innovation.digital.api.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmpresaInput {

	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;

	@NotBlank
	@Size(max = 14)
	private String cnpj;

	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
}
