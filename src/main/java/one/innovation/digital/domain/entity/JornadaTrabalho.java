package one.innovation.digital.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jornada_trabalho")
@SequenceGenerator(name = "JORNADA_TRABALHO_ID", sequenceName = "JORNADA_TRABALHO_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JornadaTrabalho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JORNADA_TRABALHO_ID_SEQ")
	@EqualsAndHashCode.Include
	private long id;

	@Column(nullable = false, length = 100)
	private String descricao;
}
