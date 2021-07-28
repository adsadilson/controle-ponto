package one.innovation.digital.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "USUARIO_ID", sequenceName = "USUARIO_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USUARIO_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private CategoriaUsuario categoriaUsuario;

	@NotBlank
	@Column(nullable = false, length = 80)
	private String nome;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Empresa  empresa;

	@ManyToOne
	@JoinColumn(nullable = false)
	private NivelAcesso nivelAcesso;

	@ManyToOne
	@JoinColumn(nullable = false)
	private JornadaTrabalho jornadaTrabalho;

	@Column(precision = 12, scale = 2)
	private BigDecimal tolerancia;

	private LocalDateTime inicioJornada;

	private LocalDateTime finalJornada;
}
