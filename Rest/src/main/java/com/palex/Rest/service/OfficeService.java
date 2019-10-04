package com.palex.Rest.service;

import com.palex.Rest.view.Office.OfficeListFilterView;
import com.palex.Rest.view.Office.OfficeListView;
import com.palex.Rest.view.Office.OfficeSaveFilterView;
import com.palex.Rest.view.Office.OfficeUpdateFilterView;
import com.palex.Rest.view.Office.OfficeView;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationListView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.Organisation.OrganisationView;

import java.util.List;

/**
 * Интерфейс сервиснного слоя для Office.
 */
public interface OfficeService {

    /**
     * Получить список объектов по параметрам.
     * @param officeListFilterView параметры запроса.
     * @return Список объектов, удовлетворяющих параметрам запроса.
     */
    List<OfficeListView> getList(OfficeListFilterView officeListFilterView);

    /**
     * Запрос объекта по UUID.
     * @param id UUID.
     * @return Объект.
     */
    OfficeView getById(Long id);

    /**
     * Запрос на обновление объекта.
     * @param officeUpdateFilterView Обновленное представление объекта.
     */
    void update(OfficeUpdateFilterView officeUpdateFilterView);

    /**
     * Запрос на сохранение объекта.
     * @param officeSaveFilterView Представление объекта для сохранения.
     */
    void save(OfficeSaveFilterView officeSaveFilterView);

}
