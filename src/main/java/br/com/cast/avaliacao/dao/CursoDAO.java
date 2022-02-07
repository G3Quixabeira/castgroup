package br.com.cast.avaliacao.dao;

import br.com.cast.avaliacao.model.CategoriaModel;
import br.com.cast.avaliacao.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CursoDAO extends JpaRepository<CursoModel, Long> {


}
