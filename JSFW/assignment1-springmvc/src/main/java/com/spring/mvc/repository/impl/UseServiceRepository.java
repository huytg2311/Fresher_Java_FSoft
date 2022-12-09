//package com.spring.mvc.repository.impl;
//
//import com.spring.mvc.model.UseService;
//import com.spring.mvc.repository.IUseServiceRepository;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//@Repository
//public class UseServiceRepository implements IUseServiceRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//    @Override
//    public List<UseService> getAllUseService() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<UseService> cq = cb.createQuery(UseService.class);
//        Root<UseService> root = cq.from(UseService.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
//    }
//
//    @Override
//    public void saveUseService(UseService useService) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(useService);
//    }
//}
