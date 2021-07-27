package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.LocalidadeEntity;
import one.innovation.digital.api.dtos.input.LocalidadeInput;
import one.innovation.digital.domain.entity.Localidade;

@Component
public class LocalidadeMapper {

	@Autowired
	private ModelMapper modelMapper;

	public LocalidadeEntity toEntity(Localidade obj) {
		return modelMapper.map(obj, LocalidadeEntity.class);
	}

	public List<LocalidadeEntity> toCollectionEntity(List<Localidade> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Localidade toDomain(LocalidadeInput input) {
		return modelMapper.map(input, Localidade.class);
	}

	public void copyToDomainObject(LocalidadeInput input, Localidade obj) {
		modelMapper.map(input, obj);
	}

}
