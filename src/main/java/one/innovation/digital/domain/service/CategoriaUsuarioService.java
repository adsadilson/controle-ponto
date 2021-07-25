package one.innovation.digital.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.domain.entity.CategoriaUsuario;
import one.innovation.digital.domain.repository.CategoriaUsuarioRepository;

@Service
@AllArgsConstructor
public class CategoriaUsuarioService {

	private CategoriaUsuarioRepository categoriaUsuarioRepository;

	public List<CategoriaUsuario> listarTodos() {
		return categoriaUsuarioRepository.findAll();
	}
}
