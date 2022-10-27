package uk.ac.acm.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.ac.acm.data.model.StudentModel;


public interface StudentModelRepo extends JpaRepository<StudentModel, String> {

	StudentModel findStudentModelByEmail(String email);

	
}
