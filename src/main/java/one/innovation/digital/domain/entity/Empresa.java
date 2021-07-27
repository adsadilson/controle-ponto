package one.innovation.digital.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "EMPRESA_ID", sequenceName = "EMPRESA_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EMPRESA_ID_SEQ")
	@EqualsAndHashCode.Include
    private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	@Column(nullable = false, length = 100)
    private String nome;
	
	@Column(nullable = false, length = 14)
    private String cnpj;
    
	@Column(length = 80)
    private String endereco;
    
	@Column(length = 80)
    private String bairro;
    
    @Column(length = 80)
    private String cidade;
    
    @Column(length = 2)
    private String estado;
    
    @Column(length = 20)
    private String telefone;
}
