package com.palex.Rest.dao.impl;

import com.palex.Rest.dao.OfficeDao;
import com.palex.Rest.model.OfficeEntity;
import com.palex.Rest.view.Office.OfficeListFilterView;
import com.palex.Rest.view.Office.OfficeUpdateFilterView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class
OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OfficeEntity> getList(OfficeListFilterView officeListFilterView) {

        String orgId = officeListFilterView.getOrgId();
        String name = officeListFilterView.getName();
        String phone = officeListFilterView.getPhone();
        String isActive = officeListFilterView.getIsActive();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> query = cb.createQuery(OfficeEntity.class);
        Root<OfficeEntity> officeEntityRoot = query.from(OfficeEntity.class);
        Predicate predicate = cb.conjunction();
        predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("orgId"), orgId));
        if (name != null){
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("name"), name));
        }
        if (phone != null) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("phone"), phone));
        }
        if (isActive != null) {
            predicate = cb.and(predicate, cb.equal(officeEntityRoot.get("isActive"), isActive));
        }
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    @Override
    public OfficeEntity getById(Long id) {
        return em.find(OfficeEntity.class, id);
    }

    @Override
    public void update(OfficeUpdateFilterView officeUpdateFilterView) {
        Long id = officeUpdateFilterView.getId();
        OfficeEntity officeEntity = em.find(OfficeEntity.class, id);

        officeEntity.setName(officeUpdateFilterView.getName());
        officeEntity.setAddress(officeUpdateFilterView.getAddress());

        if (officeEntity.getPhone() != null) {
            officeEntity.setPhone(officeUpdateFilterView.getPhone());
        }
        if (officeEntity.getIsActive() != null) {
            officeEntity.setIsActive(Boolean.parseBoolean(officeUpdateFilterView.getIsActive()));
        }
        em.merge(officeEntity);
    }

    @Override
    public void save(OfficeEntity officeEntity) {
        em.persist(officeEntity);
    }
}
