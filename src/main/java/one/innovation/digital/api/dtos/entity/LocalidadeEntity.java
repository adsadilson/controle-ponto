package one.innovation.digital.api.dtos.entity;

import lombok.Data;

@Data
public class LocalidadeEntity {
	
	private Long id;
	private NivelAcessoEntity nivelAcesso;
	private String descricao;
}
