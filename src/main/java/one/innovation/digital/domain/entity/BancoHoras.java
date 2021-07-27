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
@Table(name = "banco_hora")
@SequenceGenerator(name = "BANCO_HORA_ID", sequenceName = "BANCO_HORA_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BancoHoras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BANCO_HORA_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;
	@ManyToOne
	private Movimentacao movto;
	@ManyToOne
	private Usuario usuario;
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHoras;
	private BigDecimal saldoHoras;

}
