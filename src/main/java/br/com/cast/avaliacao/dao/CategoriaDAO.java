package br.com.cast.avaliacao.dao;

import br.com.cast.avaliacao.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoriaDAO extends JpaRepository<CategoriaModel, Long> {
	@Query("SELECT t FROM CategoriaModel t WHERE t.descricao = ?1")
	List<CategoriaModel> findByDescricao(String categoria);
}
