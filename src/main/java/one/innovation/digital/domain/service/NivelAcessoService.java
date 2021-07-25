package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.NivelAcesso;
import one.innovation.digital.domain.repository.NivelAcessoRepository;

@Service
@AllArgsConstructor
public class NivelAcessoService {

	private NivelAcessoRepository nivelAcessoRepository;

	public List<NivelAcesso> listarTodos() {
		return nivelAcessoRepository.findAll();
	}

	public NivelAcesso buscarPorId(Long id) {
		return nivelAcessoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Nivel de Acesso não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public NivelAcesso adicionar(NivelAcesso obj) {
		return nivelAcessoRepository.save(obj);
	}

	@Transactional
	public NivelAcesso atualizar(NivelAcesso obj) {
		return nivelAcessoRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			nivelAcessoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Nivel de Acesso não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(NivelAcesso obj) {
		boolean result = nivelAcessoRepository.findByDescricao(obj.getDescricao()).stream()
				.anyMatch(cat -> !cat.equals(obj));
		if (result) {
			throw new NegocioException(
					"Nivel de Acesso já cadastrada para esse [DESCRIÇÃO: " + obj.getDescricao() + "]");
		}
	}
}
