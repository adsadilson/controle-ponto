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
@Table(name = "categoria_usuario")
@SequenceGenerator(name = "CATEGORIA_USUARIO_ID", sequenceName = "CATEGORIA_USUARIO_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoriaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CATEGORIA_USUARIO_ID_SEQ")
	@EqualsAndHashCode.Include
	private long id;

	@Column(nullable = false, length = 100)
	private String descricao;
}
