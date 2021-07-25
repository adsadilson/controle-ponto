package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.NivelAcessoEntity;
import one.innovation.digital.api.dtos.input.NivelAcessoInput;
import one.innovation.digital.domain.entity.NivelAcesso;

@Component
public class NivelAcessoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public NivelAcessoEntity toEntity(NivelAcesso obj) {
		return modelMapper.map(obj, NivelAcessoEntity.class);
	}

	public List<NivelAcessoEntity> toCollectionEntity(List<NivelAcesso> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public NivelAcesso toDomain(NivelAcessoInput input) {
		return modelMapper.map(input, NivelAcesso.class);
	}

	public void copyToDomainObject(NivelAcessoInput input, NivelAcesso obj) {
		modelMapper.map(input, obj);
	}

}
