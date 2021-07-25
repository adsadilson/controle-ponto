package one.innovation.digital.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.innovation.digital.domain.entity.JornadaTrabalho;

@Repository
public interface JornadaTrabalhoRepository extends JpaRepository<JornadaTrabalho, Long> {

	Collection<JornadaTrabalho> findByDescricao(String descricao);

}
