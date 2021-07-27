package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.domain.entity.Movimentacao;
import one.innovation.digital.domain.repository.MovimentacaoRepository;

@Service
@AllArgsConstructor
public class MovimentacaoService {

	private MovimentacaoRepository movimentacaoRepository;

	public List<Movimentacao> listarTodos() {
		return movimentacaoRepository.findAll();
	}

	public Movimentacao buscarPorId(Long id) {
		return movimentacaoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Movimentacao não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public Movimentacao adicionar(Movimentacao obj) {
		return movimentacaoRepository.save(obj);
	}

	@Transactional
	public Movimentacao atualizar(Movimentacao obj) {
		return movimentacaoRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			movimentacaoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Movimentacao não pode ser deletada! possui associação com outras tabelas");
		}
	}

}
