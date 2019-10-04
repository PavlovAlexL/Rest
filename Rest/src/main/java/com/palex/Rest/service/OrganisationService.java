package com.palex.Rest.service;

import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationListView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.Organisation.OrganisationView;

import java.util.List;

/**
 * Интерфейс сервиснного слоя для Organisation.
 */
public interface OrganisationService {

    /**
     * Получить список объектов по параметрам.
     * @param organisationListFilterView параметры запроса.
     * @return Список объектов, удовлетворяющих параметрам запроса.
     */
    List<OrganisationListView> getList(OrganisationListFilterView organisationListFilterView);

    /**
     * Запрос объекта по UUID.
     * @param id UUID.
     * @return Объект.
     */
    OrganisationView getById(Long id);

    /**
     * Запрос на обновление объекта.
     * @param organisationUpdateFilterView Обновленное представление объекта.
     */
    void update(OrganisationUpdateFilterView organisationUpdateFilterView);

    /**
     * Запрос на сохранение объекта.
     * @param organisationSaveFilterView Представление объекта для соъранения.
     */
    void save(OrganisationSaveFilterView organisationSaveFilterView);

}
