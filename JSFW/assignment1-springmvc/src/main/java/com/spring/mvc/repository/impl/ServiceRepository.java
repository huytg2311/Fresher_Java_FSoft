//package com.spring.mvc.repository.impl;
//
//import com.spring.mvc.model.Service;
//import com.spring.mvc.repository.IServiceRepository;
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
//public class ServiceRepository implements IServiceRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Service> getAllService() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Service> cq = cb.createQuery(Service.class);
//        Root<Service> root = cq.from(Service.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
//    }
//
//    @Override
//    public void saveService(Service service) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(service);
//    }
//
//    @Override
//    public Service getService(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Service service = session.get(Service.class, id);
//        return service;
//    }
//
//    @Override
//    public void deleteService(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Service service = session.byId(Service.class).load(id);
//        session.delete(service);
//    }
//}
