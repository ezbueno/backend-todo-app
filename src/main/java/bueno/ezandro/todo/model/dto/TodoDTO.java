package bueno.ezandro.todo.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "done")
	private Boolean done;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "createdDate")
	private LocalDateTime createdDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "doneDate")
	private LocalDateTime doneDate;

}
