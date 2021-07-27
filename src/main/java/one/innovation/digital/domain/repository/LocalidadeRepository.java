package one.innovation.digital.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.innovation.digital.domain.entity.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long>{

	Collection<Localidade> findByDescricao(String descricao);

}
