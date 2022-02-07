package br.com.cast.avaliacao.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.cast.avaliacao.exceptions.DaoException;
import br.com.cast.avaliacao.model.CursoModel;
import br.com.cast.avaliacao.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@RestController
@RequestMapping(path = "/curso")
@Validated
public class CursoController {

	private CursoService cursoService;

	@Autowired
	public CursoController(CursoService cursoService) {

		this.cursoService = cursoService;
	}

	@ApiOperation(value = "Salva os dados de um curso")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "curso salvo"),
			@ApiResponse(code = 204, message = "Erro ao salvar um curso"),
			@ApiResponse(code = 400, message = "Requição não pode ser processada"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PostMapping
	public ResponseEntity<String> salvarCurso(@NotNull @RequestBody CursoModel curso) throws URISyntaxException {
		if(!StringUtils.hasLength(curso.getDescricao()))
			return ResponseEntity.badRequest().build();
		
		try {
			cursoService.salvarCurso(curso);
		}catch(DaoException e) {
			return ResponseEntity.badRequest().body("curso ja existente");
		}
		
		if (curso.getId() == null)
			return ResponseEntity.status(204).build();

		return ResponseEntity.created(new URI("/curso/" + curso.getId())).build();
	}

	@ApiOperation(value = "Altera os dados de um curso ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna 200 quando conclui"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PutMapping
	public ResponseEntity<CursoModel> updateCurso(@NotNull @RequestBody CursoModel curso) {

		cursoService.alterarCurso(curso);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}