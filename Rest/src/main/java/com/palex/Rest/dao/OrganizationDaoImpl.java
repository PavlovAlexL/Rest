package com.palex.Rest.dao;

import com.palex.Rest.model.OrganizationEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<OrganizationEntity> getList(OrganizationEntity organizationEntity) {
        String name = organizationEntity.getName();
        String inn = organizationEntity.getInn();
        Boolean isActive = organizationEntity.getIsActive();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrganizationEntity> query = cb.createQuery(OrganizationEntity.class);
        Root<OrganizationEntity> organisationEntityRoot = query.from(OrganizationEntity.class);
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
    public OrganizationEntity getById(Long id) {
        return entityManager.find(OrganizationEntity.class, id);
    }

    @Override
    public void update(OrganizationEntity organizationEntity) {
        entityManager.merge(organizationEntity);
    }

    @Override
    public void save(OrganizationEntity organizationEntity) {
        entityManager.persist(organizationEntity);

    }
}
