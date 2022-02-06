package br.com.cast.avaliacao.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.cast.avaliacao.model.CategoriaModel;
import br.com.cast.avaliacao.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoria")
@Validated
public class CategoriaController {

	private CategoriaService categoriaService;

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@ApiOperation(value = "Salva os dados de um categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Categoria salvo"),
			@ApiResponse(code = 204, message = "Erro ao salvar um Categoria"),
			@ApiResponse(code = 400, message = "Requição não pode ser processada"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PostMapping
	public ResponseEntity<CategoriaModel> salvarAuto(@NotNull @RequestBody CategoriaModel categoria) throws URISyntaxException {
		categoriaService.salvar(categoria);
		if (categoria.getId() == null)
			return ResponseEntity.status(204).build();
		return ResponseEntity.created(new URI("/categoria/" + categoria.getId())).build();
	}
	
	@ApiOperation(value = "Lista categorias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista obtida com sucesso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getCategoriaByNamePostNameShortName(@RequestBody CategoriaModel categoria) throws URISyntaxException {
		return ResponseEntity.ok(this.categoriaService.findCategoriaByProps(categoria));
	}
	
	@ApiOperation(value = "Obtem o categoria pelo Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Categoria obtido com sucesso"),
			@ApiResponse(code = 404, message = "Categoria não encontrado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping(path = "/{id}")
	public ResponseEntity<CategoriaModel> getCategoriaById(@PathVariable("id") Long id) throws URISyntaxException {
		CategoriaModel categoria= this.categoriaService.findCategoriaById(id);
		
		if(categoria == null || categoria.getId()==null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(categoria);
	}
}
