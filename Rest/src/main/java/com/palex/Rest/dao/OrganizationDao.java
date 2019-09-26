package com.palex.Rest.dao;

import com.palex.Rest.model.OrganizationEntity;
import com.palex.Rest.view.Organization.OrganizationListFilterView;
import com.palex.Rest.view.Organization.OrganizationListView;

import java.util.List;

public interface OrganizationDao {

    List<OrganizationEntity> getList(OrganizationEntity organizationEntity);

    OrganizationEntity getById(Long id);

    void update (OrganizationEntity organizationEntity);

    void save (OrganizationEntity organizationEntity);

}
