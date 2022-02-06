package br.com.cast.avaliacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "categoria")
@Entity
@Table(name = "tbl_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	public CategoriaModel(String descricao) {
		this.descricao = descricao;
	}
	
	public CategoriaModel() {}

}
