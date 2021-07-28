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
import one.innovation.digital.api.dtos.entity.UsuarioEntity;
import one.innovation.digital.api.dtos.input.UsuarioInput;
import one.innovation.digital.api.dtos.mapper.UsuarioMapper;
import one.innovation.digital.domain.entity.Usuario;
import one.innovation.digital.domain.service.UsuarioService;

@Api(tags = "Usuário")
@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioResource {

	private UsuarioService usuarioService;
	private UsuarioMapper mapper;

	@ApiOperation("Pesquisar um usuário por ID")
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioEntity> buscarPorId(@PathVariable Long id) {
		Usuario obj = usuarioService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todos os usuários")
	@GetMapping
	public ResponseEntity<List<UsuarioEntity>> listarTodos() {
		List<UsuarioEntity> lists = mapper.toCollectionEntity(usuarioService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra um Usuário")
	@PostMapping
	public ResponseEntity<UsuarioEntity> adicionar(@Valid @RequestBody UsuarioInput obj) {
		Usuario objNovo = usuarioService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar um usuário")
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioEntity> atualizar(@RequestBody UsuarioInput input, @PathVariable Long id) {
		Usuario obj = usuarioService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir um Usuário")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		usuarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
