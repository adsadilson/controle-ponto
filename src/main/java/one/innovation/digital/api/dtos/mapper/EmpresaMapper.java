package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.EmpresaEntity;
import one.innovation.digital.api.dtos.input.EmpresaInput;
import one.innovation.digital.domain.entity.Empresa;

@Component
public class EmpresaMapper {

	@Autowired
	private ModelMapper modelMapper;

	public EmpresaEntity toEntity(Empresa obj) {
		return modelMapper.map(obj, EmpresaEntity.class);
	}

	public List<EmpresaEntity> toCollectionEntity(List<Empresa> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Empresa toDomain(EmpresaInput input) {
		return modelMapper.map(input, Empresa.class);
	}

	public void copyToDomainObject(EmpresaInput input, Empresa obj) {
		modelMapper.map(input, obj);
	}

}
