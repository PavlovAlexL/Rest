package com.palex.Rest.dao;

import com.palex.Rest.model.OrganisationEntity;

import java.util.List;

public interface OrganisationDao {

    List<OrganisationEntity> getList(OrganisationEntity organizationEntity);

    OrganisationEntity getById(Long id);

    void update (OrganisationEntity organizationEntity);

    void save (OrganisationEntity organizationEntity);

}
