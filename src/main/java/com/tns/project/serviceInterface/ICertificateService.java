package com.tns.project.serviceInterface;

import com.tns.project.entity.Certificate;
import com.tns.project.entity.College;

public interface ICertificateService {

	Certificate addCertificate(Certificate certificate);
	Certificate updateCertificate(Certificate certificate);
	Certificate SearchCertificate(long id);
	Certificate deleteCertificate(long id);
	Certificate findByYearAndCollege(int id, College college);
	
}
