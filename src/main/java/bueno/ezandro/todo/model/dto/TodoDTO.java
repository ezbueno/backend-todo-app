package bueno.ezandro.todo.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

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

	@Column(name = "createdDate")
	private LocalDateTime createdDate;

	@Column(name = "doneDate")
	private LocalDateTime doneDate;

}
