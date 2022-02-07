package br.com.cast.avaliacao.dao;

import br.com.cast.avaliacao.model.CategoriaModel;
import br.com.cast.avaliacao.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CursoDAO extends JpaRepository<CursoModel, Long> {

	@Query("SELECT new br.com.cast.avaliacao.dto.CursoResponse( c.descricao, p.descricao) " +
			" FROM CursoModel c JOIN c.categoria p")
	List<CategoriaModel> getJoinInformation();

}
