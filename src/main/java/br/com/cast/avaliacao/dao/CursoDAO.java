package br.com.cast.avaliacao.dao;

import br.com.cast.avaliacao.model.CursoModel;

import java.util.List;
public interface CursoDAO extends DaoGenerico<CursoModel, Long> {

	List<CursoModel> findByParams(CursoModel params);

	List<CursoModel> listarCursos(Integer offset, Integer size);

}
