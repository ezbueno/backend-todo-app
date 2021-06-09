package bueno.ezandro.todo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@PrePersist
	private void beforeSave() {
		setCreatedDate(LocalDateTime.now());
	}
	
}
