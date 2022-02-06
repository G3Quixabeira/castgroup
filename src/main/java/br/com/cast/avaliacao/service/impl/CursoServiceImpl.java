package br.com.cast.avaliacao.service.impl;

import java.util.List;

import br.com.cast.avaliacao.dao.CursoDAO;
import br.com.cast.avaliacao.model.CursoModel;
import br.com.cast.avaliacao.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javassist.NotFoundException;

@Service
public class CursoServiceImpl implements CursoService {

	private CursoDAO cursoDAO;

	@Autowired
	public CursoServiceImpl(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	@Override
	public CursoModel findById(Long id) {
		return this.cursoDAO.recuperar(id);
	}

	@Transactional
	@Override
	public void salvarCurso(CursoModel livro) {
		this.cursoDAO.salvar(livro);
	}

	@Override
	public List<CursoModel> findByParams(CursoModel params) {
		return null;
	}

	@Override
	public List<CursoModel> getListaCursos(Integer offset, Integer size) {
		return null;
	}

	/*@Override
	public List<CursoModel> findByParams(CursoModel params) {
		return this.cursoDAO.findByParams(params);
	}*/

	/*@Override
	public List<CursoModel> getListaCursos(Integer offset, Integer size) {
		return this.cursoDAO.listarCursos(offset, size);
	}*/

	@Transactional
	@Override
	public void deleteCurso(Long id) {
		CursoModel lm = this.cursoDAO.recuperar(id);
		this.cursoDAO.excluir(lm);
	}

	@Override
	public void alterarStatusCurso(Long id, Integer status) throws NotFoundException {

	}

	@Transactional
	@Override
	public void alterarCurso(CursoModel livro) {
		this.cursoDAO.merge(livro);

	}

}
