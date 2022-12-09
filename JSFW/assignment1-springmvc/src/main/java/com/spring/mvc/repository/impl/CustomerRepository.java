//package com.spring.mvc.repository.impl;
//
//import com.spring.mvc.model.Customer;
//import com.spring.mvc.repository.ICustomerRepository;
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
//public class CustomerRepository implements ICustomerRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Customer> getAllCustomer() {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//        Root<Customer> root = cq.from(Customer.class);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
//    }
//
//    @Override
//    public void saveCustomer(Customer customer) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.saveOrUpdate(customer);
//    }
//
//    @Override
//    public Customer getCustomer(String id) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Customer customer = currentSession.get(Customer.class, id);
//        return customer;
//    }
//
//    @Override
//    public void deleteCustomer(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Customer customer = session.byId(Customer.class).load(id);
//        session.delete(customer);
//    }
//}
