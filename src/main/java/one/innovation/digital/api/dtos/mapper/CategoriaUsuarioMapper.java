package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.CategoriaUsuarioEntity;
import one.innovation.digital.api.dtos.input.CategoriaUsuarioInput;
import one.innovation.digital.domain.entity.CategoriaUsuario;

@Component
public class CategoriaUsuarioMapper {

	@Autowired
	private ModelMapper modelMapper;

	public CategoriaUsuarioEntity toEntity(CategoriaUsuario obj) {
		return modelMapper.map(obj, CategoriaUsuarioEntity.class);
	}

	public List<CategoriaUsuarioEntity> toCollectionEntity(List<CategoriaUsuario> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public CategoriaUsuario toDomain(CategoriaUsuarioInput input) {
		return modelMapper.map(input, CategoriaUsuario.class);
	}

	public void copyToDomainObject(CategoriaUsuarioInput input, CategoriaUsuario obj) {
		modelMapper.map(input, obj);
	}

}
