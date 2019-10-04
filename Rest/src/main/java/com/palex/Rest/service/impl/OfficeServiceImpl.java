package com.palex.Rest.service.impl;

import com.palex.Rest.dao.OfficeDao;
import com.palex.Rest.model.OfficeEntity;
import com.palex.Rest.model.mapper.MapperFacade;
import com.palex.Rest.service.OfficeService;
import com.palex.Rest.view.Office.OfficeListFilterView;
import com.palex.Rest.view.Office.OfficeListView;
import com.palex.Rest.view.Office.OfficeSaveFilterView;
import com.palex.Rest.view.Office.OfficeUpdateFilterView;
import com.palex.Rest.view.Office.OfficeView;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация сервисного слоя для объектов организации.
 */

@Service
public class OfficeServiceImpl implements OfficeService {

    private final MapperFacade facade;
    private OfficeDao dao;

    public OfficeServiceImpl(OfficeDao dao, MapperFacade facade) {
        this.dao = dao;
        this.facade = facade;
    }

    @Override
    @Transactional
    public List<OfficeListView> getList(OfficeListFilterView officeListFilterView) {
        List<OfficeEntity> officeEntityList = dao.getList(officeListFilterView);
        List<OfficeListView> officeListViews = facade.mapAsList(officeEntityList, OfficeListView.class);
        return officeListViews;
    }

    @Override
    @Transactional
    public OfficeView getById(Long id) {
        OfficeEntity officeEntity = dao.getById(id);
        OfficeView officeView = facade.map(officeEntity, OfficeView.class);
        return officeView;
    }

    @Override
    @Transactional
    public void update(OfficeUpdateFilterView officeUpdateFilterView) {
        dao.update(officeUpdateFilterView);
    }

    @Override
    @Transactional
    public void save(OfficeSaveFilterView officeSaveFilterView) {
        OfficeEntity officeEntity = facade.map(officeSaveFilterView, OfficeEntity.class);
        dao.save(officeEntity);
    }
}
