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
import one.innovation.digital.api.dtos.entity.BancoHorasEntity;
import one.innovation.digital.api.dtos.input.BancoHorasInput;
import one.innovation.digital.api.dtos.mapper.BancoHorasMapper;
import one.innovation.digital.domain.entity.BancoHoras;
import one.innovation.digital.domain.service.BancoHorasService;

@Api(tags = "Banco de Horas")
@RestController
@RequestMapping("/banco-horas")
@AllArgsConstructor
public class BancoHorasResource {

	private BancoHorasService bancoHorasService;
	private BancoHorasMapper mapper;

	@ApiOperation("Pesquisar um bando de horas por ID")
	@GetMapping("/{id}")
	public ResponseEntity<BancoHorasEntity> buscarPorId(@PathVariable Long id) {
		BancoHoras obj = bancoHorasService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Pesquisar todos banco de horas")
	@GetMapping
	public ResponseEntity<List<BancoHorasEntity>> listarTodos() {
		List<BancoHorasEntity> lists = mapper.toCollectionEntity(bancoHorasService.listarTodos());
		return ResponseEntity.ok(lists);
	}

	@ApiOperation("Cadastra um banco de horas")
	@PostMapping
	public ResponseEntity<BancoHorasEntity> adicionar(@Valid @RequestBody BancoHorasInput obj) {
		BancoHoras objNovo = bancoHorasService.adicionar(mapper.toDomain(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(mapper.toEntity(objNovo));
	}

	@ApiOperation("Atualizar um banco de horas")
	@PutMapping("/{id}")
	public ResponseEntity<BancoHorasEntity> atualizar(@RequestBody BancoHorasInput input, @PathVariable Long id) {
		BancoHoras obj = bancoHorasService.buscarPorId(id);
		mapper.copyToDomainObject(input, obj);
		return ResponseEntity.ok().body(mapper.toEntity(obj));
	}

	@ApiOperation("Excluir um banco de horas")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		bancoHorasService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
