package br.com.cast.avaliacao.service;

import java.util.List;
import java.util.Optional;

import br.com.cast.avaliacao.model.CursoModel;
import javassist.NotFoundException;

public interface CursoService {

	Optional<CursoModel> findById(Long id);

	void salvarCurso(CursoModel curso);

	List<CursoModel> findByParams(CursoModel params);

	List<CursoModel> getListaCursos(Integer offset, Integer size);

	void deleteCurso(Long id);

	void alterarCurso(CursoModel Curso);

}
