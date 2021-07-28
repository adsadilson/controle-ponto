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
import one.innovation.digital.api.dtos.entity.TipoDataEntity;
import one.innovation.digital.api.dtos.input.TipoDataInput;
import one.innovation.digital.api.dtos.mapper.TipoDataMapper;
import one.innovation.digital.domain.entity.TipoData;
import one.innovation.digital.domain.service.TipoDataService;

@Api(tags = "Tipo de data")
@RestController
@RequestMapping("/tipo-data")
@AllArgsConstructor
public class TipoDataResource {

	private TipoDataService tipoDataService;
	private TipoDataMapper mapper;

	@ApiOperation("Pesquisar um tipo de data por ID")
	@GetMapping("/{id}")
	public ResponseEntity<TipoDataEntity> buscarPorId(@PathVariable Long id) {
		TipoData obj = tipoDataService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todos tipos de data")
	@GetMapping
	public ResponseEntity<List<TipoDataEntity>> listarTodos() {
		List<TipoDataEntity> lists = mapper.toCollectionEntity(tipoDataService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra um tipo de data")
	@PostMapping
	public ResponseEntity<TipoDataEntity> adicionar(@Valid @RequestBody TipoDataInput obj) {
		TipoData objNovo = tipoDataService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar um tipo de data")
	@PutMapping("/{id}")
	public ResponseEntity<TipoDataEntity> atualizar(@RequestBody TipoDataInput input, @PathVariable Long id) {
		TipoData obj = tipoDataService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir um tipo de data")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tipoDataService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
