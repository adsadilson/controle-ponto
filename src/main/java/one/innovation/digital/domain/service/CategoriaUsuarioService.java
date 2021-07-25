package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.CategoriaUsuario;
import one.innovation.digital.domain.repository.CategoriaUsuarioRepository;

@Service
@AllArgsConstructor
public class CategoriaUsuarioService {

	private CategoriaUsuarioRepository categoriaUsuarioRepository;

	public List<CategoriaUsuario> listarTodos() {
		return categoriaUsuarioRepository.findAll();
	}

	public CategoriaUsuario buscarPorId(Long id) {
		return categoriaUsuarioRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Categoria de Usuário não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public CategoriaUsuario adicionar(CategoriaUsuario obj) {
		return categoriaUsuarioRepository.save(obj);
	}

	@Transactional
	public CategoriaUsuario atualizar(CategoriaUsuario obj) {
		return categoriaUsuarioRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			categoriaUsuarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Categoria de Usuário não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(CategoriaUsuario obj) {
		boolean result = categoriaUsuarioRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(cat -> !cat.equals(obj));
		if (result) {
			throw new NegocioException(
					"Categoria de Usuário já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
