package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.BancoHorasEntity;
import one.innovation.digital.api.dtos.input.BancoHorasInput;
import one.innovation.digital.domain.entity.BancoHoras;

@Component
public class BancoHorasMapper {

	@Autowired
	private ModelMapper modelMapper;

	public BancoHorasEntity toEntity(BancoHoras obj) {
		return modelMapper.map(obj, BancoHorasEntity.class);
	}

	public List<BancoHorasEntity> toCollectionEntity(List<BancoHoras> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public BancoHoras toDomain(BancoHorasInput input) {
		return modelMapper.map(input, BancoHoras.class);
	}

	public void copyToDomainObject(BancoHorasInput input, BancoHoras obj) {
		modelMapper.map(input, obj);
	}

}
