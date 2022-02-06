package br.com.cast.avaliacao.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.cast.avaliacao.dao.CategoriaDAO;
import br.com.cast.avaliacao.model.CategoriaModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class CategoriaDaoImpl extends DaoGenericoImpl<CategoriaModel, Long> implements CategoriaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		super.instanciate(this.entityManager, CategoriaModel.class);
	}

	@Override
	public List<CategoriaModel> findCategoriaByProps(CategoriaModel categoria) {
		StringBuilder sb = new StringBuilder("select e from CategoriaModel e where 1=1 ");
		if (StringUtils.hasLength(categoria.getDescricao())) {
			sb.append("and lower(e.descricao) like lower(:descricao) ");
		}

		TypedQuery<CategoriaModel> query = entityManager.createQuery(sb.toString(), CategoriaModel.class);
		if (StringUtils.hasLength(categoria.getDescricao())) {
			query.setParameter("descricao", "%" + categoria.getDescricao() + "%");
		}

		return query.getResultList();
	}

}
