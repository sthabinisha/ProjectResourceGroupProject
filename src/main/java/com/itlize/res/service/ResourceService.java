package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceService {

    public List<Resource> getAllResources ();
    void deleteAllResourcebyID(Integer pID);

    void getResourceName(Integer pID);
    Project addResource(Resource resource);
}
