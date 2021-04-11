package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.Resource;
import com.itlize.res.repository.ResourcesRepository;
import com.itlize.res.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
    public Optional<Resource> getResourcesById(Integer resoureceId) {
        return resourcesRepository.findById(resoureceId);
    }

    @Override
    public Resource getResourceById(Integer pID) {
        return resourcesRepository.findResourcesByResourceId(pID);
    }



    @Override
    public Resource addResource(Resource resource) {
        resource.setTimeCreated(Calendar.getInstance().getTime());
        resource.setLastUpdated(Calendar.getInstance().getTime());
        return resourcesRepository.save(resource);
    }
}
