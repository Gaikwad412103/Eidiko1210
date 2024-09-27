package pagination;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        try {
            sessionFactory=new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        if (sessionFactory==null){
            System.out.println("SessionFactory is not created !!!");
            return;
        }

        try(Session session=sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            //--Record added--
//            Books books=new Books();
//            books.setName("java programming");
//            books.setPrize(500);
//            session.save(books);
//            transaction.commit();

            // Calculate pagination parameters 
            int pageNumber = 1;
            int pageSize = 10;
            int firstResult = (pageNumber - 1) * pageSize;

// Create a HQL query to retrieve Books
            String hql = "FROM Books";
            Query<Books> query = session.createQuery(hql, Books.class);

// Set pagination parameters
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);

// Retrieve  from the database
            List<Books> list = query.getResultList();

// Display Books on the current page
            for (Books a : list) {
                System.out.println(a);
            }


        }
    }
}
