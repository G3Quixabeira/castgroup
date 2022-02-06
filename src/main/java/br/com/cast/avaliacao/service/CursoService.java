package br.com.cast.avaliacao.service;

import java.util.List;

import br.com.cast.avaliacao.model.CursoModel;
import javassist.NotFoundException;

public interface CursoService {

	CursoModel findById(Long id);
	
	void salvarCurso(CursoModel curso);

	List<CursoModel> findByParams(CursoModel params);

	List<CursoModel> getListaCursos(Integer offset, Integer size);

	void deleteCurso(Long id);

	void alterarStatusCurso(Long id, Integer status) throws NotFoundException;

	void alterarCurso(CursoModel Curso);

}
