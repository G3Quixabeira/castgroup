package br.com.cast.avaliacao.service.impl;

import br.com.cast.avaliacao.dao.CategoriaDAO;
import br.com.cast.avaliacao.model.CategoriaModel;
import br.com.cast.avaliacao.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaDAO categoriaDAO;

    @Autowired
    public CategoriaServiceImpl(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void salvar(CategoriaModel autor) {
        this.categoriaDAO.salvar(autor);

    }

    @Override
    public List<CategoriaModel> findCategoriaByProps(CategoriaModel categoria) {
        return this.categoriaDAO.findCategoriaByProps(categoria);
    }

    @Override
    public CategoriaModel findCategoriaById(Long id) {
        return this.categoriaDAO.recuperar(id);
    }

}
