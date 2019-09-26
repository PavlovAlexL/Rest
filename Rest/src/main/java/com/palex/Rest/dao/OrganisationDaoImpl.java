package com.palex.Rest.dao;

import com.palex.Rest.model.OrganisationEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager entityManager;

    public OrganisationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<OrganisationEntity> getList(OrganisationEntity organizationEntity) {
        String name = organizationEntity.getName();
        String inn = organizationEntity.getInn();
        Boolean isActive = organizationEntity.getIsActive();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
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
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public OrganisationEntity getById(Long id) {
        return entityManager.find(OrganisationEntity.class, id);
    }

    @Override
    public void update(OrganisationEntity organizationEntity) {
        entityManager.merge(organizationEntity);
    }

    @Override
    public void save(OrganisationEntity organizationEntity) {
        entityManager.persist(organizationEntity);

    }
}
