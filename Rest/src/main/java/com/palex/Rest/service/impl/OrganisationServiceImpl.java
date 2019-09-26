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

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationDao organisationDao;
    private final MapperFacade mapperFacade;

    public OrganisationServiceImpl(OrganisationDao organisationDao, MapperFacade mapperFacade) {
        this.organisationDao = organisationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public List<OrganisationListView> getList(OrganisationListFilterView organisationListFilterView) {
        OrganisationEntity organizationEntity = mapperFacade.map(organisationListFilterView, OrganisationEntity.class);
        List<OrganisationEntity> organizationEntityList = organisationDao.getList(organizationEntity);
        List<OrganisationListView> organisationListViews = mapperFacade.mapAsList(organizationEntityList, OrganisationListView.class);
        return organisationListViews;
    }

    @Override
    @Transactional
    public OrganisationView getById(Long id) {
        OrganisationEntity organizationEntity = organisationDao.getById(id);
        OrganisationView organisationView = mapperFacade.map(organizationEntity, OrganisationView.class);
        return organisationView;
    }

    @Override
    @Transactional
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {
        Long id = organisationUpdateFilterView.getId();
        OrganisationEntity organisationEntity = organisationDao.getById(id);
        organisationEntity.setName(organisationUpdateFilterView.getName());
        organisationEntity.setFullName(organisationUpdateFilterView.getFullName());
        organisationEntity.setInn(organisationUpdateFilterView.getInn());
        organisationEntity.setKpp(organisationUpdateFilterView.getKpp());
        organisationEntity.setAddress(organisationUpdateFilterView.getAddress());
        if(organisationUpdateFilterView.getPhone() != null){
            organisationEntity.setPhone(organisationUpdateFilterView.getPhone());
        }
        if(organisationUpdateFilterView.getIsActive() != null){
            organisationEntity.setIsActive(organisationUpdateFilterView.getIsActive());
        }


        organisationDao.update(organisationEntity);
    }

    @Override
    @Transactional
    public void save(OrganisationSaveFilterView organisationSaveFilterView) {
        OrganisationEntity organizationEntity = mapperFacade.map(organisationSaveFilterView, OrganisationEntity.class);
        organisationDao.save(organizationEntity);
    }
}
