package br.com.cast.avaliacao.service.impl;

import br.com.cast.avaliacao.dao.CategoriaDAO;
import br.com.cast.avaliacao.model.CategoriaModel;
import br.com.cast.avaliacao.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaDAO categoriaDAO;

    @Autowired
    public CategoriaServiceImpl(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void salvar(CategoriaModel categoria) {
        this.categoriaDAO.save(categoria);

    }

    @Override
    public List<CategoriaModel> findCategoriaByProps(CategoriaModel categoria) {
        return this.categoriaDAO.findByDescricao(categoria.getDescricao());
    }

    @Override
    public Optional<CategoriaModel> findCategoriaById(Long id) {

        return this.categoriaDAO.findById(id);
    }

}
