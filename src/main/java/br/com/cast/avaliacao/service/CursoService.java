package br.com.cast.avaliacao.service;

import java.util.List;
import java.util.Optional;

import br.com.cast.avaliacao.model.CursoModel;
import javassist.NotFoundException;

public interface CursoService {


	void salvarCurso(CursoModel curso);

	void alterarCurso(CursoModel Curso);

}
