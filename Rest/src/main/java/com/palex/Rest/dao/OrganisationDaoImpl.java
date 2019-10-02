package com.palex.Rest.dao;

import com.palex.Rest.model.OrganisationEntity;
import com.palex.Rest.view.Organisation.OrganisationListFilterView;
import com.palex.Rest.view.Organisation.OrganisationUpdateFilterView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class
OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrganisationEntity> getList(OrganisationListFilterView organisationListFilterView) {
        String name = organisationListFilterView.getName();
        String inn = organisationListFilterView.getInn();
        Boolean isActive = Boolean.parseBoolean(organisationListFilterView.getIsActive());

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrganisationEntity> query = cb.createQuery(OrganisationEntity.class);
        Root<OrganisationEntity> organisationEntityRoot = query.from(OrganisationEntity.class);
        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("name"), name));

        if (inn != null) {
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("inn"), inn));
        }
        if (isActive != null) {
            predicate = cb.and(predicate, cb.equal(organisationEntityRoot.get("isActive"), isActive));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    @Override
    public OrganisationEntity getById(Long id) {
        return em.find(OrganisationEntity.class, id);
    }

    @Override
    public void update(OrganisationUpdateFilterView organisationUpdateFilterView) {
        Long id = organisationUpdateFilterView.getId();
        OrganisationEntity organisationEntity = em.find(OrganisationEntity.class, id);

        organisationEntity.setName(organisationUpdateFilterView.getName());
        organisationEntity.setFullName(organisationUpdateFilterView.getFullName());
        organisationEntity.setInn(organisationUpdateFilterView.getInn());
        organisationEntity.setKpp(organisationEntity.getKpp());
        organisationEntity.setAddress(organisationEntity.getAddress());
        if (organisationEntity.getPhone() != null) {
            organisationEntity.setPhone(organisationEntity.getPhone());
        }
        if (organisationEntity.getIsActive() != null) {
            organisationEntity.setIsActive(organisationEntity.getIsActive());
        }
        em.merge(organisationEntity);
    }

    @Override
    public void save(OrganisationEntity organisationEntity) {
        em.persist(organisationEntity);
    }
}
