package one.innovation.digital.api.dtos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class UsuarioEntity {

	private Long id;
	private CategoriaUsuarioEntity categoriaUsuario;
	private String nome;
	
	@JsonIgnoreProperties({ "cnpj", "endereco", "bairro", "cidade", "estado", "telefone" })
	private EmpresaEntity empresa;
	
	private NivelAcessoEntity nivelAcesso;
	
	private JornadaTrabalhoEntity jornadaTrabalho;
	
	private BigDecimal tolerancia;
	private LocalDateTime inicioJornada;
	private LocalDateTime finalJornada;
}
