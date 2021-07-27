package one.innovation.digital.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_data")
@SequenceGenerator(name = "TIPO_DATA_ID", sequenceName = "TIPO_DATA_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TIPO_DATA_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(nullable = false, length = 100)
	private String descricao;
}
