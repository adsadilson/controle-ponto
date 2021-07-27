package one.innovation.digital.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "movimentacao")
@SequenceGenerator(name = "MOVIMENTACAO_ID", sequenceName = "MOVIMENTACAO_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MOVIMENTACAO_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	private Usuario usuario;

	private LocalDateTime dataEntrada;
	
	private LocalDateTime dataSaida;
	
	private BigDecimal periodo;
	
	@ManyToOne
	private Ocorrencia ocorrencia;
	
	@ManyToOne
	private Calendario calendario;
}
