package com.palex.Rest.dao;

import com.palex.Rest.model.OfficeEntity;
import com.palex.Rest.view.Office.OfficeListFilterView;
import com.palex.Rest.view.Office.OfficeUpdateFilterView;

import java.util.List;

/**
 * DAO слой для Организации.
 */
public interface OfficeDao {

    /**
     * Получить список объектов по параметрам.
     * @param officeListFilterView параметры запроса.
     * @return Список объектов, удовлетворяющих параметрам запроса.
     */
    List<OfficeEntity> getList(OfficeListFilterView officeListFilterView);

    /**
     * Запрос объекта по UUID.
     * @param id UUID.
     * @return Объект.
     */
    OfficeEntity getById(Long id);

    /**
     * Запрос на обновление объекта.
     * @param officeUpdateFilterView Обновленное представление объекта.
     */
    void update(OfficeUpdateFilterView officeUpdateFilterView);

    /**
     * Запрос на сохранение объекта.
     * @param officeEntity Представление объекта для соъранения.
     */
    void save(OfficeEntity officeEntity);

}
