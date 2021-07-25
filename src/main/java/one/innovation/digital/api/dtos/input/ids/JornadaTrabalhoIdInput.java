package one.innovation.digital.api.dtos.input.ids;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JornadaTrabalhoIdInput {

	@NotNull
	private Long id;
}
