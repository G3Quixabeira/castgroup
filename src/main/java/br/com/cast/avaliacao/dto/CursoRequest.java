package br.com.cast.avaliacao.dto;

import br.com.cast.avaliacao.model.CursoModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CursoRequest {
    private CursoModel curso;

    public CursoRequest(CursoModel curso) {
        this.curso = curso;
    }
    public CursoRequest() {
    }
}
