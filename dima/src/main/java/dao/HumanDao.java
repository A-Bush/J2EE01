package dao;

import entity.Human;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HumanDao implements GeneralDaoInterface<Human> {

    @Override
    public void save(Human human) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(human);
        em.getTransaction().commit();
        em.close();
    }
}
