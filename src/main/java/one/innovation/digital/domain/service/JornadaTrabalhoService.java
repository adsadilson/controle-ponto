package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.JornadaTrabalho;
import one.innovation.digital.domain.repository.JornadaTrabalhoRepository;

@Service
@AllArgsConstructor
public class JornadaTrabalhoService {

	private JornadaTrabalhoRepository jornadaTrabalhoRepository;

	public List<JornadaTrabalho> listarTodos() {
		return jornadaTrabalhoRepository.findAll();
	}

	public JornadaTrabalho buscarPorId(Long id) {
		return jornadaTrabalhoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Jornada de Trabalho não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public JornadaTrabalho adicionar(JornadaTrabalho obj) {
		return jornadaTrabalhoRepository.save(obj);
	}

	@Transactional
	public JornadaTrabalho atualizar(JornadaTrabalho obj) {
		return jornadaTrabalhoRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			jornadaTrabalhoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Jornada de Trabalho não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(JornadaTrabalho obj) {
		boolean result = jornadaTrabalhoRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(cat -> !cat.equals(obj));
		if (result) {
			throw new NegocioException(
					"Jornada de Trabalho já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
