package br.com.cast.avaliacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Curso")
@Entity
@Table(name="tbl_curso",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
@DynamicUpdate
public class CursoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(columnDefinition = "text")
	private String descricao;
	@NotNull
	private LocalDate dataInicio;
	@NotNull
	private LocalDate dataFim;

	private Integer nrAlunos;

	@ManyToOne(fetch = FetchType.EAGER)
	private CategoriaModel categoria;
	
}
