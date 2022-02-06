package br.com.cast.avaliacao.dao;

import br.com.cast.avaliacao.model.CategoriaModel;

import java.util.List;


public interface CategoriaDAO extends DaoGenerico<CategoriaModel, Long>{

	List<CategoriaModel> findCategoriaByProps(CategoriaModel autor);

}
