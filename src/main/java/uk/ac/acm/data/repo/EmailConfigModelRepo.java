package uk.ac.acm.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.ac.acm.data.model.EmailConfigModel;
import uk.ac.acm.data.model.StudentModel;


public interface EmailConfigModelRepo extends JpaRepository<EmailConfigModel, String> {

	EmailConfigModel findEmailConfigModelBySupportTitleAndLocation(String supportTitle , String location);

	
}
