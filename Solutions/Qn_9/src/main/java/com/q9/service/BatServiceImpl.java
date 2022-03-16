package com.q9.service;

import com.q9.bat.BatDetailsRequest;
import com.q9.model.BatModel;


public interface BatServiceImpl {
   BatModel createBat(BatDetailsRequest request);
   BatModel getBatById(int id);
    void deleteBatById(BatModel batModel);
   BatModel UpdateBatById(BatModel batModel);
}
