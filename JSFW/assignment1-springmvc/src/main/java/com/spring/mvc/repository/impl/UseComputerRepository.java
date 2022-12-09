//package com.spring.mvc.repository.impl;
//
//import com.spring.mvc.model.UseComputer;
//import com.spring.mvc.repository.IUseComputerRepository;
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
//public class UseComputerRepository implements IUseComputerRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<UseComputer> getAllUseComputer() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<UseComputer> cq = cb.createQuery(UseComputer.class);
//        Root<UseComputer> root = cq.from(UseComputer.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
//    }
//
//    @Override
//    public void saveUseComputer(UseComputer useComputer) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.saveOrUpdate(useComputer);
//    }
//}
