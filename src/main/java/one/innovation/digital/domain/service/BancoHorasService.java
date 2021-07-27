package one.innovation.digital.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.api.execption.EntidadeEmUsoException;
import one.innovation.digital.api.execption.EntidadeNaoEncontradaException;
import one.innovation.digital.domain.entity.BancoHoras;
import one.innovation.digital.domain.repository.BancoHorasRepository;

@Service
@AllArgsConstructor
public class BancoHorasService {

	private BancoHorasRepository bancoHorasRepository;

	public List<BancoHoras> listarTodos() {
		return bancoHorasRepository.findAll();
	}

	public BancoHoras buscarPorId(Long id) {
		return bancoHorasRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException("Banco de Horas não encontrada para esse [ID: " + id + "]"));
	}

	@Transactional
	public BancoHoras adicionar(BancoHoras obj) {
		return bancoHorasRepository.save(obj);
	}

	@Transactional
	public BancoHoras atualizar(BancoHoras obj) {
		return bancoHorasRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			bancoHorasRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					"Banco de Horas não pode ser deletada! possui associação com outras tabelas");
		}
	}

}
