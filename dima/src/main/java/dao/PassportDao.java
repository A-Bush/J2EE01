package dao;


import entity.PassportData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PassportDao implements GeneralDaoInterface<PassportData>{

    @Override
    public void save(PassportData passportData) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(passportData);

        em.getTransaction().commit();
        em.close();
    }
}
