package one.innovation.digital.config;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.innovation.digital.domain.entity.CategoriaUsuario;
import one.innovation.digital.domain.entity.NivelAcesso;
import one.innovation.digital.domain.entity.Ocorrencia;
import one.innovation.digital.domain.repository.CategoriaUsuarioRepository;
import one.innovation.digital.domain.repository.NivelAcessoRepository;
import one.innovation.digital.domain.repository.OcorrenciaRepository;

@Service
@AllArgsConstructor
public class DBService {

	private CategoriaUsuarioRepository catUsuarioRepository;
	private OcorrenciaRepository ocorrenciaRepository;
	private NivelAcessoRepository nivelAcessoRepository;

	// @formatter:off

	public void instanciaBaseDado() {
		popularCatUsuario();
		popularOcorrencia();
		popularNivelAcesso();
	}
	
	private void popularCatUsuario() {
		CategoriaUsuario cat = new CategoriaUsuario(1L, "GERENTE");
		CategoriaUsuario cat1 = new CategoriaUsuario(2L, "ALMOXARIFE");
		CategoriaUsuario cat2 = new CategoriaUsuario(3L, "VENDEDOR");
		CategoriaUsuario cat3 = new CategoriaUsuario(4L, "RECEPCIONISTA");
		CategoriaUsuario cat4 = new CategoriaUsuario(5L, "ADMINISTRATIVO");
		catUsuarioRepository.saveAll(Arrays.asList(cat,cat1,cat2,cat3,cat4));
	}
	
	private void popularOcorrencia() {
		Ocorrencia oc = new Ocorrencia(1L,  "MOTIVOS DE DESLIGAMENTO", "DISPENSA SEM JUSTA CAUSA");
		Ocorrencia oc1 = new Ocorrencia(2L, "MOTIVOS DE DESLIGAMENTO", "DISPENSA POR JUSTA CAUSA");
		Ocorrencia oc2 = new Ocorrencia(3L, "MOTIVOS DE DESLIGAMENTO", "APOSENTADORIA");
		Ocorrencia oc3 = new Ocorrencia(4L, "MOTIVOS DE DESLIGAMENTO", "FALECIMENTO");
		Ocorrencia oc4 = new Ocorrencia(5L, "EVENTUAIS", "VIAGEM À SERVIÇO");
		Ocorrencia oc5 = new Ocorrencia(6L, "EVENTUAIS", "CASAMENTO");
		Ocorrencia oc6 = new Ocorrencia(7L, "MOTIVOS DE SAÚDE", "AUXÍLIO DOENÇA");
		Ocorrencia oc7 = new Ocorrencia(8L, "MOTIVOS DE SAÚDE", "INSS");
		Ocorrencia oc8 = new Ocorrencia(9L, "PADRÃO", "FERIAS");
		Ocorrencia oc9 = new Ocorrencia(10L,"PADRÃO", "FERIADO");
		ocorrenciaRepository.saveAll(Arrays.asList(oc,oc1,oc2,oc3,oc4,oc5,oc6,oc7,oc8,oc9));
	}
	
	private void popularNivelAcesso() {
		NivelAcesso obj = new NivelAcesso(1L, "ADMINISTRADOR");
		NivelAcesso obj1 = new NivelAcesso(2L, "CONFENRISTA");
		NivelAcesso obj2 = new NivelAcesso(3L, "ESTOQUISTA");
		NivelAcesso obj3 = new NivelAcesso(4L, "OPERADOR DE CAIXA");
		NivelAcesso obj4 = new NivelAcesso(5L, "VENDEDOR(a)");
		nivelAcessoRepository.saveAll(Arrays.asList(obj,obj1,obj2,obj3,obj4));
	}

		// @formatter:on
}
