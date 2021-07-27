package one.innovation.digital.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.innovation.digital.domain.entity.TipoData;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long>{

	Collection<TipoData> findByDescricao(String descricao);

}
