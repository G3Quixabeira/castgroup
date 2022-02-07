package br.com.cast.avaliacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

	@OneToOne(targetEntity = CategoriaModel.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="ct_fk",referencedColumnName = "id")
	private CategoriaModel categoria;

	public CursoModel(Long id, String descricao, LocalDate dataInicio, LocalDate dataFim, Integer nrAlunos, Long categoriaId,String categoriaDescricao) {
		this.id = id;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.nrAlunos = nrAlunos;
		this.categoria = new CategoriaModel(categoriaId, categoriaDescricao);;
	}

	public CursoModel() { }
}
