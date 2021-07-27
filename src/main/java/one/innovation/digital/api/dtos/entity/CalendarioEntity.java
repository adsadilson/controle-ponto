package one.innovation.digital.api.dtos.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CalendarioEntity {

	private Long id;
	private TipoDataEntity tipoData;
	private String descricao;
	private LocalDateTime dataEspecial;
}
