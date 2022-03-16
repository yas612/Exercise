package com.q12.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.q12.model.Pencil;
import com.q12.repository.PencilRepository;


@Service
public class PencilService implements PencilServiceImpl{
	
	private static final Logger log = LoggerFactory.getLogger(PencilService.class);
	
	@Autowired
	private PencilRepository repository;

	@Override
	public Pencil addPencil(Pencil pencil) {
		log.info("The pencil with name "+pencil.getName()+" is added");
		return repository.save(pencil);
	}

	@Override
	public Pencil findPencilById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Pencil> findAllPencil() {
		
		return repository.findAll();
	}

	@Override
	public String deletePencilById(int id) {
		repository.deleteById(id);
		return "pencil with id "+id+" is deleted";
	}

	@Override
	public Pencil updatePencil(Pencil pencil) {
		
		return repository.save(pencil);
	}

}
