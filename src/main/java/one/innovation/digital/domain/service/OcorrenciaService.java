package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.Ocorrencia;
import one.innovation.digital.domain.repository.OcorrenciaRepository;

@Service
@AllArgsConstructor
public class OcorrenciaService {

	private OcorrenciaRepository ocorrenciaRepository;

	public List<Ocorrencia> listarTodos() {
		return ocorrenciaRepository.findAll();
	}

	public Ocorrencia buscarPorId(Long id) {
		return ocorrenciaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Ocorrencia não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public Ocorrencia adicionar(Ocorrencia obj) {
		return ocorrenciaRepository.save(obj);
	}

	@Transactional
	public Ocorrencia atualizar(Ocorrencia obj) {
		return ocorrenciaRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			ocorrenciaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Ocorrencia não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(Ocorrencia obj) {
		boolean result = ocorrenciaRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(oc -> !oc.equals(obj));
		if (result) {
			throw new NegocioException(
					"Ocorrencia já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
