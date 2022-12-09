//package com.spring.mvc.repository.impl;
//
//import com.spring.mvc.model.Computer;
//import com.spring.mvc.repository.IComputerRepository;
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
//public class ComputerRepository implements IComputerRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Computer> getAllComputer() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Computer> cq = cb.createQuery(Computer.class);
//        Root<Computer> root = cq.from(Computer.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
//    }
//
//    @Override
//    public void saveComputer(Computer computer) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.saveOrUpdate(computer);
//    }
//
//    @Override
//    public Computer getComputer(String id) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Computer computer = currentSession.get(Computer.class, id);
//        return computer;
//    }
//
//    @Override
//    public void deleteComputer(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Computer computer = session.byId(Computer.class).load(id);
//        session.delete(computer);
//    }
//}
