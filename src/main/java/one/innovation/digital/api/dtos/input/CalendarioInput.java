package one.innovation.digital.api.dtos.input;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;
import one.innovation.digital.api.dtos.input.ids.TipoDataIdInput;

@Data
public class CalendarioInput {

	@NonNull
	private TipoDataIdInput tipoData;

	@NotBlank
	@Size(min = 3, max = 100)
	private String descricao;

	private LocalDateTime dataEspecial;
}
