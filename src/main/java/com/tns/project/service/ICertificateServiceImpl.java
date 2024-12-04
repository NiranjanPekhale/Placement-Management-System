package com.tns.project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.project.entity.Certificate;
import com.tns.project.entity.College;
import com.tns.project.repository.ICertificateRepository;
import com.tns.project.serviceInterface.ICertificateService;


@Service
public class ICertificateServiceImpl implements ICertificateService {

	@Autowired
	ICertificateRepository repo;
	public ICertificateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Certificate addCertificate(Certificate certificate) {
		
		return repo.save(certificate);
	}

	@Override
	public Certificate updateCertificate(Certificate certificate) {
		try {
			repo.findById(certificate.getId()).get();
			return repo.save(certificate);	
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Certificate SearchCertificate(long id) {
		try {
			return repo.findById(id).get();				
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Certificate deleteCertificate(long id) {
		try {
			repo.findById(id).get();
			repo.deleteById(id);
			return repo.findById(id).get();
		}catch(NoSuchElementException e)
		{
			return null;
		}
	}

	@Override
	public Certificate findByYearAndCollege(int id, College college) {
		// TODO Auto-generated method stub
		return repo.findByYearAndCollege(id, college);
	}

}
