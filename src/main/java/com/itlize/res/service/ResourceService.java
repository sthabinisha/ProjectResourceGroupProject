package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.Resource;

import java.util.List;
import java.util.Optional;


public interface ResourceService {

    public List<Resource> getAllResources();

    void deleteAllResourcebyID(Integer pID);

    public Optional<Resource> getResourcesById(Integer resoureceId);

    Resource getResourceById(Integer pID);
    Resource addResource(Resource resource);
}


