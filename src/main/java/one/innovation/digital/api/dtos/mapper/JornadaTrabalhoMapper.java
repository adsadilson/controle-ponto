package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.JornadaTrabalhoEntity;
import one.innovation.digital.api.dtos.input.JornadaTrabalhoInput;
import one.innovation.digital.domain.entity.JornadaTrabalho;

@Component
public class JornadaTrabalhoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public JornadaTrabalhoEntity toEntity(JornadaTrabalho obj) {
		return modelMapper.map(obj, JornadaTrabalhoEntity.class);
	}

	public List<JornadaTrabalhoEntity> toCollectionEntity(List<JornadaTrabalho> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public JornadaTrabalho toDomain(JornadaTrabalhoInput input) {
		return modelMapper.map(input, JornadaTrabalho.class);
	}

	public void copyToDomainObject(JornadaTrabalhoInput input, JornadaTrabalho obj) {
		modelMapper.map(input, obj);
	}

}
