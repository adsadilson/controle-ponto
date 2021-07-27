package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.UsuarioEntity;
import one.innovation.digital.api.dtos.input.UsuarioInput;
import one.innovation.digital.domain.entity.Usuario;

@Component
public class UsuarioMapper {

	@Autowired
	private ModelMapper modelMapper;

	public UsuarioEntity toEntity(Usuario obj) {
		return modelMapper.map(obj, UsuarioEntity.class);
	}

	public List<UsuarioEntity> toCollectionEntity(List<Usuario> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Usuario toDomain(UsuarioInput input) {
		return modelMapper.map(input, Usuario.class);
	}

	public void copyToDomainObject(UsuarioInput input, Usuario obj) {
		modelMapper.map(input, obj);
	}

}
