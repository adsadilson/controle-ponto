package one.innovation.digital.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.innovation.digital.domain.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Collection<Empresa> findByNome(String nome);

}
