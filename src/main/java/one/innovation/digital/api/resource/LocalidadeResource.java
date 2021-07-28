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
import one.innovation.digital.api.dtos.entity.LocalidadeEntity;
import one.innovation.digital.api.dtos.input.LocalidadeInput;
import one.innovation.digital.api.dtos.mapper.LocalidadeMapper;
import one.innovation.digital.domain.entity.Localidade;
import one.innovation.digital.domain.service.LocalidadeService;

@Api(tags = "Localidade")
@RestController
@RequestMapping("/localidades")
@AllArgsConstructor
public class LocalidadeResource {

	private LocalidadeService localidadeService;
	private LocalidadeMapper mapper;

	@ApiOperation("Pesquisar uma localidade por ID")
	@GetMapping("/{id}")
	public ResponseEntity<LocalidadeEntity> buscarPorId(@PathVariable Long id) {
		Localidade obj = localidadeService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todas as localidades")
	@GetMapping
	public ResponseEntity<List<LocalidadeEntity>> listarTodos() {
		List<LocalidadeEntity> lists = mapper.toCollectionEntity(localidadeService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Adicionar uma localidade")
	@PostMapping
	public ResponseEntity<LocalidadeEntity> adicionar(@Valid @RequestBody LocalidadeInput obj) {
		Localidade objNovo = localidadeService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar uma localidade")
	@PutMapping("/{id}")
	public ResponseEntity<LocalidadeEntity> atualizar(@RequestBody LocalidadeInput input,
			@PathVariable Long id) {
		Localidade obj = localidadeService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir uma localidade")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		localidadeService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
