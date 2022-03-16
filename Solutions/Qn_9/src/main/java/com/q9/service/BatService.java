package com.q9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.q9.bat.BatDetailsRequest;
import com.q9.model.BatModel;
import com.q9.repository.BatRepository;


@Service
public class BatService implements BatServiceImpl{
	
	@Autowired
    BatRepository batRepository;

    @Override
    public BatModel createBat(BatDetailsRequest request) {
        BatModel batModel = new BatModel();
        batModel.setName(request.getName());
        batModel.setPrice(request.getPrice());
        return batRepository.save(batModel);
    }

    @Override
    public BatModel getBatById(int BatId) {
        return batRepository.findById(BatId).get();
    }

    @Override
    public void deleteBatById(BatModel BatModel) {
        batRepository.delete(BatModel);
    }

    @Override
    public BatModel UpdateBatById(BatModel BatModel) {
        return batRepository.save(BatModel);
    }

}
