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

import lombok.AllArgsConstructor;
import one.innovation.digital.api.dtos.entity.JornadaTrabalhoEntity;
import one.innovation.digital.api.dtos.input.JornadaTrabalhoInput;
import one.innovation.digital.api.dtos.mapper.JornadaTrabalhoMapper;
import one.innovation.digital.domain.entity.JornadaTrabalho;
import one.innovation.digital.domain.service.JornadaTrabalhoService;

@RestController
@RequestMapping("/jornada-trabalho")
@AllArgsConstructor
public class JornadaTrabalhoResource {

	private JornadaTrabalhoService jornadaTrabalhoService;
	private JornadaTrabalhoMapper mapper;

	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalhoEntity> buscarPorId(@PathVariable Long id) {
		JornadaTrabalho obj = jornadaTrabalhoService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@GetMapping
	public ResponseEntity<List<JornadaTrabalhoEntity>> listarTodos() {
		List<JornadaTrabalhoEntity> lists = mapper.toCollectionEntity(jornadaTrabalhoService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@PostMapping
	public ResponseEntity<JornadaTrabalhoEntity> adicionar(@Valid @RequestBody JornadaTrabalhoInput obj) {
		JornadaTrabalho objNovo = jornadaTrabalhoService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<JornadaTrabalhoEntity> atualizar(@RequestBody JornadaTrabalhoInput input,
			@PathVariable Long id) {
		JornadaTrabalho obj = jornadaTrabalhoService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		jornadaTrabalhoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
