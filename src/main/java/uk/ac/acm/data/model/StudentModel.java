package uk.ac.acm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Learners")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
public class StudentModel {
	
	@Id
	private int LearnerID;
	private String email;
	@Column(name = "`Recent Course`" )
	private String RecentCourse;
}
