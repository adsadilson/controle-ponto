package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.CalendarioEntity;
import one.innovation.digital.api.dtos.input.CalendarioInput;
import one.innovation.digital.domain.entity.Calendario;

@Component
public class CalendarioMapper {

	@Autowired
	private ModelMapper modelMapper;

	public CalendarioEntity toEntity(Calendario obj) {
		return modelMapper.map(obj, CalendarioEntity.class);
	}

	public List<CalendarioEntity> toCollectionEntity(List<Calendario> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Calendario toDomain(CalendarioInput input) {
		return modelMapper.map(input, Calendario.class);
	}

	public void copyToDomainObject(CalendarioInput input, Calendario obj) {
		modelMapper.map(input, obj);
	}

}
