package com.palex.Rest.controller;

import com.palex.Rest.service.OrganisationService;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationListView;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import com.palex.Rest.view.Organisation.OrganisationView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для api/organisation
 */
@RestController
@RequestMapping(value = "/api/organisation", produces = "application/json")
public class OrganisationController {

    private OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    /**
     * Получить список организаций по параметрам.
     * @param organizationListFilterView параметры организации.
     * @return список организаций.
     */
    @PostMapping("/list")
    public List<OrganisationListView> getList(@RequestBody @Valid OrganisationListFilterView organizationListFilterView){
        return organisationService.getList(organizationListFilterView);
    }

    /**
     * Получить организацию оп идентификатору.
     * @param id идентификатор.
     * @return объект организации.
     */
    @GetMapping("{id:\\d+}")
    public OrganisationView getById(@PathVariable Long id){
        return organisationService.getById(id);
    }

    /**
     * Обновить данные организации.
     * @param organizationUpdateFilterView Обновленные данные организации.
     */
    @PostMapping("/update")
    public void update(@RequestBody @Valid OrganisationUpdateFilterView organizationUpdateFilterView){
        organisationService.update(organizationUpdateFilterView);
    }

    /**
     * Сохранить организацию.
     * @param organizationSaveFilterView Данные организации.
     */
    @PostMapping("/save")
    public void save(@RequestBody @Valid OrganisationSaveFilterView organizationSaveFilterView){
        System.out.println(organizationSaveFilterView);
        organisationService.save(organizationSaveFilterView);
    }

}
