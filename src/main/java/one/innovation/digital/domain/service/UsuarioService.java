package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.Usuario;
import one.innovation.digital.domain.repository.UsuarioRepository;

@Service
@AllArgsConstructor
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException("Usuario não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public Usuario adicionar(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	@Transactional
	public Usuario atualizar(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			usuarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Usuario não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(Usuario obj) {
		boolean result = usuarioRepository.findByNome(obj.getNome()).stream().anyMatch(oc -> !oc.equals(obj));
		if (result) {
			throw new NegocioException("Usuario já cadastrada para esse [NOME: " + obj.getNome() + "]");
		}
	}
}
