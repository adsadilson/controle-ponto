package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.api.execption.NegocioException;
import one.innovation.digital.domain.entity.Empresa;
import one.innovation.digital.domain.repository.EmpresaRepository;

@Service
@AllArgsConstructor
public class EmpresaService {

	private EmpresaRepository empresaRepository;

	public List<Empresa> listarTodos() {
		return empresaRepository.findAll();
	}

	public Empresa buscarPorId(Long id) {
		return empresaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Empresa não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public Empresa adicionar(Empresa obj) {
		return empresaRepository.save(obj);
	}

	@Transactional
	public Empresa atualizar(Empresa obj) {
		return empresaRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			empresaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Empresa não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public void categoriaExistente(Empresa obj) {
		boolean result = empresaRepository.findByNome(obj.getNome()).stream()
				.anyMatch(oc -> !oc.equals(obj));
		if (result) {
			throw new NegocioException(
					"Empresa já cadastrada para esse [NOME: " + obj.getNome() + "]");
		}
	}
}
