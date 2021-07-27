package one.innovation.digital.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.innovation.digital.api.dtos.entity.MovimentacaoEntity;
import one.innovation.digital.api.dtos.input.MovimentacaoInput;
import one.innovation.digital.domain.entity.Movimentacao;

@Component
public class MovimentacaoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public MovimentacaoEntity toEntity(Movimentacao obj) {
		return modelMapper.map(obj, MovimentacaoEntity.class);
	}

	public List<MovimentacaoEntity> toCollectionEntity(List<Movimentacao> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Movimentacao toDomain(MovimentacaoInput input) {
		return modelMapper.map(input, Movimentacao.class);
	}

	public void copyToDomainObject(MovimentacaoInput input, Movimentacao obj) {
		modelMapper.map(input, obj);
	}

}
