package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.Localidade;
import one.innovation.digital.domain.repository.LocalidadeRepository;

@Service
@AllArgsConstructor
public class LocalidadeService {

	private LocalidadeRepository localidadeRepository;

	public List<Localidade> listarTodos() {
		return localidadeRepository.findAll();
	}

	public Localidade buscarPorId(Long id) {
		return localidadeRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Localidade não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public Localidade adicionar(Localidade obj) {
		return localidadeRepository.save(obj);
	}

	@Transactional
	public Localidade atualizar(Localidade obj) {
		return localidadeRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			localidadeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Localidade não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(Localidade obj) {
		boolean result = localidadeRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(oc -> !oc.equals(obj));
		if (result) {
			throw new NegocioException(
					"Localidade já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
