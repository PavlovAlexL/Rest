package com.palex.Rest.service.impl;

import com.palex.Rest.dao.OrganisationDao;
import com.palex.Rest.model.OrganisationEntity;
import com.palex.Rest.model.mapper.MapperFacade;
import com.palex.Rest.service.OrganisationService;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationListView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.Organisation.OrganisationView;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация сервисного слоя для объектов организации.
 */

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private final MapperFacade facade;
    private OrganisationDao dao;

    public OrganisationServiceImpl(OrganisationDao dao, MapperFacade facade) {
        this.dao = dao;
        this.facade = facade;
    }

    @Override
    @Transactional
    public List<OrganisationListView> getList(OrganisationListFilterView organisationListFilterView) {
        List<OrganisationEntity> organisationEntityList = dao.getList(organisationListFilterView);
        return facade.mapAsList(organisationEntityList, OrganisationListView.class);
    }

    @Override
    @Transactional
    public OrganisationView getById(Long id) {
        OrganisationEntity organisationEntity = dao.getById(id);
        return facade.map(organisationEntity, OrganisationView.class);
    }

    @Override
    @Transactional
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {
        dao.update(organisationUpdateFilterView);
    }

    @Override
    @Transactional
    public void save(OrganisationSaveFilterView organisationSaveFilterView) {
        OrganisationEntity organisationEntity = facade.map(organisationSaveFilterView, OrganisationEntity.class);
        dao.save(organisationEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
