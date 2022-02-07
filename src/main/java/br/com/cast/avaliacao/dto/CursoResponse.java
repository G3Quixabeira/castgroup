package br.com.cast.avaliacao.dto;

import br.com.cast.avaliacao.model.CursoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CursoResponse {

    private String descricao;
    private String CategoriaDescricao;

    public CursoResponse(String descricao, String categoriaDescricao) {
        this.descricao = descricao;
        CategoriaDescricao = categoriaDescricao;
    }

    public CursoResponse() {
    }
}
