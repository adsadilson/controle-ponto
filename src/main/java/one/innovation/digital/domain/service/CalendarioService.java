package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.Calendario;
import one.innovation.digital.domain.repository.CalendarioRepository;

@Service
@AllArgsConstructor
public class CalendarioService {

	private CalendarioRepository calendarioRepository;

	public List<Calendario> listarTodos() {
		return calendarioRepository.findAll();
	}

	public Calendario buscarPorId(Long id) {
		return calendarioRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Calendario não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public Calendario adicionar(Calendario obj) {
		return calendarioRepository.save(obj);
	}

	@Transactional
	public Calendario atualizar(Calendario obj) {
		return calendarioRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			calendarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Calendario não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(Calendario obj) {
		boolean result = calendarioRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(oc -> !oc.equals(obj));
		if (result) {
			throw new NegocioException(
					"Calendario já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
