package ua.artcode.testio.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by serhii on 27.03.16.
 */
public class JPQLExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();


        // jpql, hql, sql + oop
        Query query =
                manager.createQuery("SELECT u FROM Student u WHERE u.name=:inName");

        List list =
                query.setParameter("inName", "Gavriil")
                        .setFirstResult(1)
                        .setMaxResults(2).getResultList();

        list.stream().forEach(System.out::println);
    }
}
