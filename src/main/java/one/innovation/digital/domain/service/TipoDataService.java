package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.TipoData;
import one.innovation.digital.domain.repository.TipoDataRepository;

@Service
@AllArgsConstructor
public class TipoDataService {

	private TipoDataRepository tipoDataRepository;

	public List<TipoData> listarTodos() {
		return tipoDataRepository.findAll();
	}

	public TipoData buscarPorId(Long id) {
		return tipoDataRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Tipo de Data não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public TipoData adicionar(TipoData obj) {
		return tipoDataRepository.save(obj);
	}

	@Transactional
	public TipoData atualizar(TipoData obj) {
		return tipoDataRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			tipoDataRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Tipo de Data não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(TipoData obj) {
		boolean result = tipoDataRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(cat -> !cat.equals(obj));
		if (result) {
			throw new NegocioException(
					"Tipo de Data já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
