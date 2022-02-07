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

	@Override
	public Optional<CursoModel> findById(Long id) {

		return this.cursoDAO.findById(id);
	}

	@Transactional
	@Override
	public void salvarCurso(CursoModel livro) {
		this.cursoDAO.save(livro);
	}

	@Override
	public List<CursoModel> findByParams(CursoModel params) {
		return null;
	}

	@Override
	public List<CursoModel> getListaCursos(Integer offset, Integer size) {
		Pageable paging = PageRequest.of(offset, size);
		 Page<CursoModel> pagedResult =  this.cursoDAO.findAll(paging);

		 if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<CursoModel>();
		}
	}

	@Transactional
	@Override
	public void deleteCurso(Long id) {
		Optional<CursoModel> curso = this.cursoDAO.findById(id);
		if(!Optional.ofNullable(curso).isPresent())
			this.cursoDAO.delete(curso.get());
	}

	@Transactional
	@Override
	public void alterarCurso(CursoModel livro) {
		this.cursoDAO.save(livro);
	}

}
