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
import one.innovation.digital.api.dtos.entity.CalendarioEntity;
import one.innovation.digital.api.dtos.input.CalendarioInput;
import one.innovation.digital.api.dtos.mapper.CalendarioMapper;
import one.innovation.digital.domain.entity.Calendario;
import one.innovation.digital.domain.service.CalendarioService;

@Api(tags = "Calendario")
@RestController
@RequestMapping("/calendarios")
@AllArgsConstructor
public class CalendarioResource {

	private CalendarioService calendarioService;
	private CalendarioMapper mapper;

	@ApiOperation("Pesquisar um calendario por ID")
	@GetMapping("/{id}")
	public ResponseEntity<CalendarioEntity> buscarPorId(@PathVariable Long id) {
		Calendario obj = calendarioService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todos os calendarios")
	@GetMapping
	public ResponseEntity<List<CalendarioEntity>> listarTodos() {
		List<CalendarioEntity> lists = mapper.toCollectionEntity(calendarioService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra um calendario")
	@PostMapping
	public ResponseEntity<CalendarioEntity> adicionar(@Valid @RequestBody CalendarioInput obj) {
		Calendario objNovo = calendarioService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar um calendario")
	@PutMapping("/{id}")
	public ResponseEntity<CalendarioEntity> atualizar(@RequestBody CalendarioInput input,
			@PathVariable Long id) {
		Calendario obj = calendarioService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		calendarioService.atualizar(obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir um calendario")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		calendarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
