package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.ResourceDetails;

import java.util.Date;
import java.util.List;

public interface ResourceDetailsService {
    public List<ResourceDetails> getAllResourcesDetails ();
    String deleteAllResourceDetailsByID(Integer recordId);
    Date getTimeCreatedbyId(Integer recordId);

    String getColumnValueByResourceId(Integer recordId);
    ResourceDetails addResourceDetails(ResourceDetails resourceDetails);
    ResourceDetails updateResourceDetail(Integer recordId);


}
