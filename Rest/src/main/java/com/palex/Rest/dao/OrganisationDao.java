package com.palex.Rest.dao;

import com.palex.Rest.model.OrganisationEntity;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import java.util.List;

/**
 * DAO слой для Организации.
 */
public interface OrganisationDao {

    /**
     * Получить список объектов по параметрам.
     * @param organisationListFilterView параметры запроса.
     * @return Список объектов, удовлетворяющих параметрам запроса.
     */
    List<OrganisationEntity> getList(OrganisationListFilterView organisationListFilterView);

    /**
     * Запрос объекта по UUID.
     * @param id UUID.
     * @return Объект.
     */
    OrganisationEntity getById(Long id);

    /**
     * Запрос на обновление объекта.
     * @param organisationUpdateFilterView Обновленное представление объекта.
     */
    void update(OrganisationUpdateFilterView organisationUpdateFilterView);

    /**
     * Запрос на сохранение объекта.
     * @param organisationSaveFilterView Представление объекта для соъранения.
     */
    void save(OrganisationEntity organisationEntity);

}
