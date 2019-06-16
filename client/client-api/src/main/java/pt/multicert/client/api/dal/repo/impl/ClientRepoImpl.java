package pt.multicert.client.api.dal.repo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pt.multicert.client.api.dal.entity.Client;
import pt.multicert.client.api.dal.repo.ClientRepo;

/**
 * Implementation for the client repo to db client table manipulation
 * @author artur
 *
 */
public class ClientRepoImpl implements ClientRepo {

    @Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void save(Client c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();
        session.close();
    }

    @Transactional(readOnly=true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Client> findAllForName(String nome) {
        Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Client.class);
        c.add(Restrictions.eq("nome", nome));
        return c.list();
    }

    @Transactional(readOnly=true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Client> findAll() {
        Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Client.class);
        return c.list();
    }

    @Transactional(readOnly=true)
    @Override
    public Client findForNif(String nif) {
        Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Client.class);
        c.add(Restrictions.eq("nif", nif));
        return (Client) c.uniqueResult();
    }

    @Override
    @Transactional
    public void delete(Client c) {
        this.sessionFactory.getCurrentSession().delete(c);
    }

}
