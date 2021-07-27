package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.OcorrenciaEntity;
import one.innovation.digital.api.dtos.input.OcorrenciaInput;
import one.innovation.digital.domain.entity.Ocorrencia;

@Component
public class OcorrenciaMapper {

	@Autowired
	private ModelMapper modelMapper;

	public OcorrenciaEntity toEntity(Ocorrencia obj) {
		return modelMapper.map(obj, OcorrenciaEntity.class);
	}

	public List<OcorrenciaEntity> toCollectionEntity(List<Ocorrencia> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Ocorrencia toDomain(OcorrenciaInput input) {
		return modelMapper.map(input, Ocorrencia.class);
	}

	public void copyToDomainObject(OcorrenciaInput input, Ocorrencia obj) {
		modelMapper.map(input, obj);
	}

}
