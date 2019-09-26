package com.palex.Rest.service;

import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationListView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.Organisation.OrganisationView;

import java.util.List;

public interface OrganisationService {

    List<OrganisationListView> getList(OrganisationListFilterView organisationListFilterView);

    OrganisationView getById(Long id);

    void update (OrganisationUpdateFilterView organisationUpdateFilterView);

    void save (OrganisationSaveFilterView organisationSaveFilterView);

}
