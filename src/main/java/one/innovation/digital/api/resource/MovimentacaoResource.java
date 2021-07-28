package one.innovation.digital.api.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import one.innovation.digital.api.dtos.entity.MovimentacaoEntity;
import one.innovation.digital.api.dtos.input.MovimentacaoInput;
import one.innovation.digital.api.dtos.mapper.MovimentacaoMapper;
import one.innovation.digital.domain.entity.Movimentacao;
import one.innovation.digital.domain.service.MovimentacaoService;

@Api(tags = "Movimentação")
@RestController
@RequestMapping("/movimentacoes")
@AllArgsConstructor
public class MovimentacaoResource {

	private MovimentacaoService movimentacaoService;
	private MovimentacaoMapper mapper;

	@ApiOperation("Pesquisar uma movimentação por ID")
	@GetMapping("/{id}")
	public ResponseEntity<MovimentacaoEntity> buscarPorId(@PathVariable Long id) {
		Movimentacao obj = movimentacaoService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todas movimentações")
	@GetMapping
	public ResponseEntity<List<MovimentacaoEntity>> listarTodos() {
		List<MovimentacaoEntity> lists = mapper.toCollectionEntity(movimentacaoService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra uma movimentação")
	@PostMapping
	public ResponseEntity<MovimentacaoEntity> adicionar(@Valid @RequestBody MovimentacaoInput obj) {
		Movimentacao objNovo = movimentacaoService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar uma movimentação")
	@PutMapping("/{id}")
	public ResponseEntity<MovimentacaoEntity> atualizar(@RequestBody MovimentacaoInput input,
			@PathVariable Long id) {
		Movimentacao obj = movimentacaoService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir uma movimentação")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		movimentacaoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
