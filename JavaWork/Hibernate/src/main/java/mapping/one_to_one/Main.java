package mapping.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed: " + e);
            return; // Exit the program if SessionFactory cannot be created
        }

        try (Session session = sessionFactory.openSession()) {
            // Create Passport
            Passport passport = new Passport();
            passport.setPassportNo(412103); // Don't set ID if using @GeneratedValue

            // Create Person
            Person person = new Person();
            person.setName("Avinash");
            person.setPassport(passport);



            // ---------------Retrive all record------------

            String hql="from Person";
            Query query=session.createQuery(hql);
            List<Person> list=query.list();
            for(Person p:list){
                System.out.println(p);
            }

            //-----------------------------------------------

            // Begin transaction
            Transaction transaction = session.beginTransaction();
            session.save(person); // This will also save passport due to CascadeType.ALL
            transaction.commit();

            System.out.println("Done!!!"+ LocalDate.now());
        } catch (Exception e) {
            System.err.println("Error during transaction: " + e);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close(); // Close the SessionFactory to release resources
            }
        }
    }
}
