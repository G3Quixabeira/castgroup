package br.com.cast.avaliacao.service;

import java.util.List;
import java.util.Optional;

import br.com.cast.avaliacao.model.CategoriaModel;

public interface CategoriaService {

	void salvar(CategoriaModel categoria);

	List<CategoriaModel> findCategoriaByProps(CategoriaModel categoria);

	Optional<CategoriaModel> findCategoriaById(Long id);

}
