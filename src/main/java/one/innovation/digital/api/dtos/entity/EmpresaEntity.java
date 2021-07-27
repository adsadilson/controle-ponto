package one.innovation.digital.api.dtos.entity;

import lombok.Data;

@Data
public class EmpresaEntity {
    
    private Long id;
    private String nome;
	private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
}
