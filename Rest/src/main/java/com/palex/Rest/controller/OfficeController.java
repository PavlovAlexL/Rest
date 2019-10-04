package com.palex.Rest.controller;

import com.palex.Rest.service.OfficeService;
import com.palex.Rest.service.OrganisationService;
import com.palex.Rest.view.Office.OfficeListFilterView;
import com.palex.Rest.view.Office.OfficeSaveFilterView;
import com.palex.Rest.view.Office.OfficeUpdateFilterView;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.ResponseView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Контроллер для api/organisation
 */
@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    private OfficeService service;

    public OfficeController(OfficeService service) {
        this.service = service;
    }

    /**
     * Получить список организаций по параметрам.
     *
     * @param officeListFilterView параметры организации.
     * @return список организаций.
     */
    @PostMapping("/list")
    public ResponseView getList(@Valid @RequestBody OfficeListFilterView officeListFilterView) {
        return new ResponseView(service.getList(officeListFilterView));
    }

    /**
     * Получить организацию оп идентификатору.
     *
     * @param id идентификатор.
     * @return объект организации.
     */
    @GetMapping("{id:\\d+}")
    public ResponseView getById(@PathVariable Long id) {
        return new ResponseView(service.getById(id));
    }

    /**
     * Обновить данные организации.
     *
     * @param officeUpdateFilterView Обновленные данные организации.
     */
    @PostMapping("/update")
    public ResponseView update(@Valid @RequestBody OfficeUpdateFilterView officeUpdateFilterView) {
        service.update(officeUpdateFilterView);
        return new ResponseView();
    }

    /**
     * Сохранить организацию.
     *
     * @param officeSaveFilterView Данные организации.
     */
    @PostMapping("/save")
    public ResponseView save(@Valid @RequestBody OfficeSaveFilterView officeSaveFilterView) {
        service.save(officeSaveFilterView);
        return new ResponseView();
    }

}
