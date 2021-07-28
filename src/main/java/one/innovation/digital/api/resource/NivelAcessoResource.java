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
import one.innovation.digital.api.dtos.entity.NivelAcessoEntity;
import one.innovation.digital.api.dtos.input.NivelAcessoInput;
import one.innovation.digital.api.dtos.mapper.NivelAcessoMapper;
import one.innovation.digital.domain.entity.NivelAcesso;
import one.innovation.digital.domain.service.NivelAcessoService;

@Api(tags = "Nivél de acesso")
@RestController
@RequestMapping("/nivel-acesso")
@AllArgsConstructor
public class NivelAcessoResource {

	private NivelAcessoService nivelAcessoService;
	private NivelAcessoMapper mapper;

	@ApiOperation("Pesquisar um nivél de acesso por ID")
	@GetMapping("/{id}")
	public ResponseEntity<NivelAcessoEntity> buscarPorId(@PathVariable Long id) {
		NivelAcesso obj = nivelAcessoService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todos nivél de acesso")
	@GetMapping
	public ResponseEntity<List<NivelAcessoEntity>> listarTodos() {
		List<NivelAcessoEntity> lists = mapper.toCollectionEntity(nivelAcessoService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra um nivél de acesso")
	@PostMapping
	public ResponseEntity<NivelAcessoEntity> adicionar(@Valid @RequestBody NivelAcessoInput obj) {
		NivelAcesso objNovo = nivelAcessoService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar um nivél de acesso")
	@PutMapping("/{id}")
	public ResponseEntity<NivelAcessoEntity> atualizar(@RequestBody NivelAcessoInput input,
			@PathVariable Long id) {
		NivelAcesso obj = nivelAcessoService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir um nivél de acesso")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		nivelAcessoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
