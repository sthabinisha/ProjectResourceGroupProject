package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.ResourceDetails;

import java.util.Date;
import java.util.List;

public interface ResourceDetailsService {
    public List<ResourceDetails> getAllResourcesDetails ();
    String deleteAllResourceDetailsByID(Long recordId);
    Date getTimeCreatedbyId(Long recordId);

    String getColumnValueByResourceId(Long recordId);
    ResourceDetails addResourceDetails(ResourceDetails resourceDetails);
    ResourceDetails updateResourceDetail(Long recordId, ResourceDetails resourceDetails);


}
