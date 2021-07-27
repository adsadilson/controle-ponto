package one.innovation.digital.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "localidade")
@SequenceGenerator(name = "LOCALIDADE_ID", sequenceName = "LOCALIDADE_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Localidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "LOCALIDADE_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	private NivelAcesso nivelAcesso;

	@Column(length = 100)
	private String descricao;
}
