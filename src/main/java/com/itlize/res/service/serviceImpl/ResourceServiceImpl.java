package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import com.itlize.res.repository.ResourcesRepository;
import com.itlize.res.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceServiceImpl implements ResourceService {


    @Autowired
    private ResourcesRepository resourcesRepository;
    @Override
    public List<Resource> getAllResources() {
        return resourcesRepository.findAll();
    }

    @Override
    public void deleteAllResourcebyID(Integer pID) {

    }

    @Override
    public void getResourceName(Integer pID) {

    }

    @Override
    public Project addResource(Resource resource) {
        return null;
    }
}
