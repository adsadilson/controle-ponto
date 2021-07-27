package one.innovation.digital.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "calendario")
@SequenceGenerator(name = "CALENDARIO_ID", sequenceName = "CALENDARIO_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Calendario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CALENDARIO_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	private TipoData tipoData;

	@Column(length = 100)
	private String descricao;

	private LocalDateTime dataEspecial;
}
