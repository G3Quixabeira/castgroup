package br.com.cast.avaliacao.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.cast.avaliacao.dao.CursoDAO;
import br.com.cast.avaliacao.model.CursoModel;
import br.com.cast.avaliacao.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImpl implements CursoService {

	private CursoDAO cursoDAO;

	@Autowired
	public CursoServiceImpl(CursoDAO cursoDAO) {

		this.cursoDAO = cursoDAO;
	}



	@Transactional
	@Override
	public void salvarCurso(CursoModel livro) {
		this.cursoDAO.save(livro);
	}


	@Transactional
	@Override
	public void alterarCurso(CursoModel livro) {
		this.cursoDAO.save(livro);
	}

}
