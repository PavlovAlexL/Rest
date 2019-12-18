package com.palex.Rest.controller;

import com.palex.Rest.service.OrganisationService;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.ResponseView;
import com.palex.Rest.view.SuccessView;
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
@RequestMapping(value = "/api/organisation")
public class OrganisationController {

    private OrganisationService service;

    public OrganisationController(OrganisationService service) {
        this.service = service;
    }

    /**
     * Получить список организаций по параметрам.
     *
     * @param organisationListFilterView параметры организации.
     * @return список организаций.
     */
    @PostMapping("/list")
    public ResponseView getList(@Valid @RequestBody OrganisationListFilterView organisationListFilterView) {
        return new ResponseView(service.getList(organisationListFilterView));
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
     * @param organisationUpdateFilterView Обновленные данные организации.
     */
    @PostMapping("/update")
    public SuccessView update(@Valid @RequestBody OrganisationUpdateFilterView organisationUpdateFilterView) {
        service.update(organisationUpdateFilterView);
        return new SuccessView();
    }

    /**
     * Сохранить организацию.
     *
     * @param organisationSaveFilterView Данные организации.
     */
    @PostMapping("/save")
    public SuccessView save(@Valid @RequestBody OrganisationSaveFilterView organisationSaveFilterView) {
        service.save(organisationSaveFilterView);
        return new SuccessView();
    }

    /**
     * Удалить организацию.
     *
     * @param id идентификатор.
     */
    @PostMapping("/delete/{id:\\d+}")
    public SuccessView delete(@PathVariable Long id) {
        service.delete(id);
        return new SuccessView();
    }

}
