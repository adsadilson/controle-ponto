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
import one.innovation.digital.api.dtos.entity.CategoriaUsuarioEntity;
import one.innovation.digital.api.dtos.input.CategoriaUsuarioInput;
import one.innovation.digital.api.dtos.mapper.CategoriaUsuarioMapper;
import one.innovation.digital.domain.entity.CategoriaUsuario;
import one.innovation.digital.domain.service.CategoriaUsuarioService;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaUsuarioResource {

	private CategoriaUsuarioService categoriaUsuarioService;
	private CategoriaUsuarioMapper mapper;

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaUsuarioEntity> buscarPorId(@PathVariable Long id) {
		CategoriaUsuario obj = categoriaUsuarioService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@GetMapping
	public ResponseEntity<List<CategoriaUsuarioEntity>> listarTodos() {
		List<CategoriaUsuarioEntity> lists = mapper.toCollectionEntity(categoriaUsuarioService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@PostMapping
	public ResponseEntity<CategoriaUsuarioEntity> adicionar(@Valid @RequestBody CategoriaUsuarioInput obj) {
		CategoriaUsuario objNovo = categoriaUsuarioService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaUsuarioEntity> atualizar(@RequestBody CategoriaUsuarioInput input,
			@PathVariable Long id) {
		CategoriaUsuario obj = categoriaUsuarioService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		categoriaUsuarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
