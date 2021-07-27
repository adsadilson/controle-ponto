package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.TipoDataEntity;
import one.innovation.digital.api.dtos.input.TipoDataInput;
import one.innovation.digital.domain.entity.TipoData;

@Component
public class TipoDataMapper {

	@Autowired
	private ModelMapper modelMapper;

	public TipoDataEntity toEntity(TipoData obj) {
		return modelMapper.map(obj, TipoDataEntity.class);
	}

	public List<TipoDataEntity> toCollectionEntity(List<TipoData> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public TipoData toDomain(TipoDataInput input) {
		return modelMapper.map(input, TipoData.class);
	}

	public void copyToDomainObject(TipoDataInput input, TipoData obj) {
		modelMapper.map(input, obj);
	}

}
