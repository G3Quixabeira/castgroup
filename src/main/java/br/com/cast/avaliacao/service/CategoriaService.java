package br.com.cast.avaliacao.service;

import java.util.List;

import br.com.cast.avaliacao.model.CategoriaModel;

public interface CategoriaService {

	void salvar(CategoriaModel categoria);

	List<CategoriaModel> findCategoriaByProps(CategoriaModel categoria);

	CategoriaModel findCategoriaById(Long id);

}
