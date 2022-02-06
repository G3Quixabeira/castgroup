package br.com.cast.avaliacao.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.cast.avaliacao.dao.CursoDAO;
import br.com.cast.avaliacao.model.CursoModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


@Repository
public class CursoDAOImpl extends DaoGenericoImpl<CursoModel, Long> implements CursoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		super.instanciate(this.entityManager, CursoModel.class);
	}

	@Override
	public List<CursoModel> findByParams(CursoModel params) {
		StringBuilder sb = new StringBuilder("select e from CursoModel e where 1=1 ");
		if (StringUtils.hasLength(params.getDescricao())) {
			sb.append("and lower(e.descricao) like lower(:descricao) ");
		}

		TypedQuery<CursoModel> query = entityManager.createQuery(sb.toString(), CursoModel.class);

		if (StringUtils.hasLength(params.getDescricao())) {
			query.setParameter("descricao", "%" + params.getDescricao() + "%");
		}

		return query.getResultList();
	}

	public List<CursoModel> listarCursos(Integer offset, Integer size) {
		TypedQuery<CursoModel> query = entityManager.createQuery("select e from CursoModel e", CursoModel.class);
		query.setFirstResult(offset);
		query.setMaxResults(size);
	
		return query.getResultList();
	}

}
