package com.palex.Rest.dao;

import com.palex.Rest.model.OrganisationEntity;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;

import java.util.List;

public interface OrganisationDao {

    List<OrganisationEntity> getList(OrganisationListFilterView organisationListFilterView);

    OrganisationEntity getById(Long id);

    void update(OrganisationUpdateFilterView organisationUpdateFilterView);

    void save(OrganisationEntity organisationEntity);

}
