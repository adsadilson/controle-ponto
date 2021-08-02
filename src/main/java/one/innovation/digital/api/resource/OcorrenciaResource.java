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
import one.innovation.digital.api.dtos.entity.OcorrenciaEntity;
import one.innovation.digital.api.dtos.input.OcorrenciaInput;
import one.innovation.digital.api.dtos.mapper.OcorrenciaMapper;
import one.innovation.digital.domain.entity.Ocorrencia;
import one.innovation.digital.domain.service.OcorrenciaService;

@Api(tags = "Ocorrencia")
@RestController
@RequestMapping("/ocorrencias")
@AllArgsConstructor
public class OcorrenciaResource {

	private OcorrenciaService ocorrenciaService;
	private OcorrenciaMapper mapper;

	@ApiOperation("Pesquisar uma ocorrencia por ID")
	@GetMapping("/{id}")
	public ResponseEntity<OcorrenciaEntity> buscarPorId(@PathVariable Long id) {
		Ocorrencia obj = ocorrenciaService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todas as ocorrencias")
	@GetMapping
	public ResponseEntity<List<OcorrenciaEntity>> listarTodos() {
		List<OcorrenciaEntity> lists = mapper.toCollectionEntity(ocorrenciaService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra uma ocorrencia")
	@PostMapping
	public ResponseEntity<OcorrenciaEntity> adicionar(@Valid @RequestBody OcorrenciaInput obj) {
		Ocorrencia objNovo = ocorrenciaService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar uma ocorrencia")
	@PutMapping("/{id}")
	public ResponseEntity<OcorrenciaEntity> atualizar(@RequestBody OcorrenciaInput input,
			@PathVariable Long id) {
		Ocorrencia obj = ocorrenciaService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		ocorrenciaService.atualizar(obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir uma ocorrencia")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		ocorrenciaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
