package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.ResourceDetails;
import com.itlize.res.repository.ResourceDetailsRepository;
import com.itlize.res.service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {


    @Autowired
    ResourceDetailsRepository resourceDetailsRepository;

    @Override
    public List<ResourceDetails> getAllResourcesDetails() {
        return resourceDetailsRepository.findAll();
    }

    @Override
    public String deleteAllResourceDetailsByID(Integer recordId) {
        resourceDetailsRepository.deleteById(recordId);
        return "Deleted resource details by ID: "+ recordId;
    }

    @Override
    public Date getTimeCreatedbyId(Integer recordId) {
        return null;
    }

    @Override
    public String getColumnValueByResourceId(Integer recordId) {
        return null;
    }

    @Override
    public ResourceDetails addResourceDetails(ResourceDetails resourceDetails) {
        return resourceDetailsRepository.save(resourceDetails);
    }

    @Override
    public ResourceDetails updateResourceDetail(Integer recordId, ResourceDetails resourceDetails) {
        ResourceDetails resourceDetails1 = resourceDetailsRepository.findByRecordId(recordId);
      //  resourceDetails1.setResource(resourceDetails.getResource());
        resourceDetails1.setColumnValue(resourceDetails.getColumnValue());

      //  resourceDetails1.setColumnId(resourceDetails.getColumnId());
        return resourceDetailsRepository.save(resourceDetails1);
    }


}
