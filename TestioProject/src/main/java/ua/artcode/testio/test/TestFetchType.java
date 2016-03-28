package ua.artcode.testio.test;

import ua.artcode.testio.model.Course;
import ua.artcode.testio.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 27.03.16.
 */
public class TestFetchType {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Teacher teacher1 = new Teacher("Bloch3",5);
        for (int i = 0; i < 1000; i++) {
            teacher1.getCourses().add(new Course(String.valueOf(i), "desc",teacher1));
        }


        manager.getTransaction().begin();
        manager.persist(teacher1);
        manager.getTransaction().commit();


        manager.clear();


        Teacher teacher = manager.createQuery("SELECT t FROM Teacher t WHERE t.name = :tName", Teacher.class)
                .setParameter("tName", "Bloch").getSingleResult();

        System.out.println(teacher);

        int level = teacher.getLevel();

        int size = teacher.getCourses().size();


    }
}
