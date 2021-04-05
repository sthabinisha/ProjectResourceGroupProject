package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.ResourceDetails;
import com.itlize.res.service.ResourceDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {



    @Override
    public List<ResourceDetails> getAllResourcesDetails() {
        return null;
    }

    @Override
    public String deleteAllResourceDetailsByID(Integer recordId) {
        return null;
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
        return null;
    }

    @Override
    public ResourceDetails updateResourceDetail(Integer recordId) {
        return null;
    }
}
