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
import lombok.AllArgsConstructor;
import one.innovation.digital.api.dtos.entity.EmpresaEntity;
import one.innovation.digital.api.dtos.input.EmpresaInput;
import one.innovation.digital.api.dtos.mapper.EmpresaMapper;
import one.innovation.digital.domain.entity.Empresa;
import one.innovation.digital.domain.service.EmpresaService;

@Api(tags = "Empresa")
@RestController
@RequestMapping("/empresas")
@AllArgsConstructor
public class EmpresaResource {

	private EmpresaService empresaService;
	private EmpresaMapper mapper;

	@GetMapping("/{id}")
	public ResponseEntity<EmpresaEntity> buscarPorId(@PathVariable Long id) {
		Empresa obj = empresaService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@GetMapping
	public ResponseEntity<List<EmpresaEntity>> listarTodos() {
		List<EmpresaEntity> lists = mapper.toCollectionEntity(empresaService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@PostMapping
	public ResponseEntity<EmpresaEntity> adicionar(@Valid @RequestBody EmpresaInput obj) {
		Empresa objNovo = empresaService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmpresaEntity> atualizar(@RequestBody EmpresaInput input,
			@PathVariable Long id) {
		Empresa obj = empresaService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		empresaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
