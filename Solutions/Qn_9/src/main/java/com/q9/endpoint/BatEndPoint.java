package com.q9.endpoint;


import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.q9.exception.BatException;
import com.q9.model.BatModel;
import com.q9.service.BatService;
import com.q9.bat.*;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

@Endpoint
public class BatEndPoint {
    private static final String NAMESPACE_URI = "http://www.q9.com/bat";

    @Autowired
    private BatService batService;

    @Resource
    private WebServiceContext ctx;

    @SneakyThrows
    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "BatDetailsRequest")
    @ResponsePayload
    public BatDetailsResponse getBatRequest(@RequestPayload BatDetailsRequest request) throws Exception {
        BatDetailsResponse response = new BatDetailsResponse();
        Bat Bat = new Bat();
        BatModel batModel;
        try {
        	batModel = batService.createBat(request);
            BeanUtils.copyProperties(batModel, Bat);
        } catch (Exception ex) {
            String msg = "Internal server issue";
            ServiceStatus status = new ServiceStatus();
            status.setStatusCode("500");
            status.setMessage(msg);
            throw new BatException(msg, status);
        }
        response.setBat(Bat);

        return response;
    }

    @SneakyThrows
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBatByIdRequest")
    @ResponsePayload
    public GetBatByIdResponse getBat(@RequestPayload GetBatByIdRequest request) {
        GetBatByIdResponse response = new GetBatByIdResponse();
        BatInfo BatInfo = new BatInfo();
        BatModel BatDetails = batService.getBatById(request.getId());
        if (null == BatDetails) {
            String msg = String.format("Details of Bat with id %s is not found", request.getId());
            ServiceStatus status = new ServiceStatus();
            status.setStatusCode("404");
            status.setMessage(msg);
            throw new BatException(msg, status);
        }
        BeanUtils.copyProperties(BatDetails, BatInfo);
        response.setBatInfo(BatInfo);
        return response;
    }

    @SneakyThrows
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBatByIdRequest")
    @ResponsePayload
    public DeleteBatByIdResponse deleteBat(@RequestPayload DeleteBatByIdRequest request) {
        ServiceStatus serviceStatus = new ServiceStatus();
        DeleteBatByIdResponse response = new DeleteBatByIdResponse();
        BatModel BatDetails = batService.getBatById(request.getId());
        if (null != BatDetails) {
            serviceStatus.setStatusCode("200");
            serviceStatus.setMessage("Success");
        }else {
            String msg = String.format("Details of Bat with id %s is not found", request.getId());
            ServiceStatus status = new ServiceStatus();
            status.setStatusCode("404");
            status.setMessage(msg);
            throw new BatException(msg, status);
        }
        batService.deleteBatById(BatDetails);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @SneakyThrows
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBatByIdRequest")
    @ResponsePayload
    public UpdateBatByIdResponse updateBat(@RequestPayload UpdateBatByIdRequest request) {
        ServiceStatus serviceStatus = new ServiceStatus();
        UpdateBatByIdResponse response = new UpdateBatByIdResponse();
        BatModel BatDetails = batService.getBatById(request.getId());
        if (null != BatDetails) {
            serviceStatus.setStatusCode("200");
            serviceStatus.setMessage("Success");
        }else {
            String msg = String.format("Details of Bat with id %s is not found", request.getId());
            ServiceStatus status = new ServiceStatus();
            status.setStatusCode("404");
            status.setMessage(msg);
            throw new BatException(msg, status);
        }
        BeanUtils.copyProperties(request, BatDetails);
        batService.UpdateBatById(BatDetails);
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
