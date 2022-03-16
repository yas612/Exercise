package com.q12.service;

import java.util.List;

import com.q12.model.Pencil;

public interface PencilServiceImpl {

	Pencil addPencil(Pencil pencil);
	Pencil findPencilById(int id);
	List<Pencil> findAllPencil();
	String deletePencilById(int id);
	Pencil updatePencil(Pencil pencil);
}
