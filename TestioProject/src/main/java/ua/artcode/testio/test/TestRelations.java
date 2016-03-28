package ua.artcode.testio.test;

import ua.artcode.testio.model.Course;
import ua.artcode.testio.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 27.03.16.
 */
public class TestRelations {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Course course1 = new Course("1", "desc");
        Course course2 = new Course("2", "desc");
        Course course3 = new Course("3", "desc");
        Course course4 = new Course("4", "desc");

        Teacher teacher1 = new Teacher("Ivan",5);
        Teacher teacher2 = new Teacher("Serhii",5);
        Teacher teacher3 = new Teacher("Valera",5);


        course1.setOwner(teacher1);
        course2.setOwner(teacher1);

        teacher1.getCourses().add(course1);
        teacher1.getCourses().add(course2);

        course3.setOwner(teacher2);
        teacher2.getCourses().add(course3);

        course4.setOwner(teacher3);
        teacher3.getCourses().add(course4);

        manager.getTransaction().begin();
        manager.persist(course1);
        manager.persist(course2);
        manager.persist(course3);
        manager.persist(course4);
        manager.persist(teacher1);
        manager.persist(teacher2);
        manager.persist(teacher3);
        manager.getTransaction().commit();
    }
}
