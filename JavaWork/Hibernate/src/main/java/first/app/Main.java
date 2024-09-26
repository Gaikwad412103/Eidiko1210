package first.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try{
            SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
//-----------------Add Record--------------------
//            Subject subject=new Subject();
//            subject.setName("Java");
//            subject.setPrize(500);
//            System.out.println("Record inserted successfully!!!");
//            session.save(subject);
//-----------------Retrive Record ------------------
//            Subject subject=session.get(Subject.class,1);
//            System.out.println(subject);
//----------------Delete Record ---------------------
//            Subject subject=session.get(Subject.class,1);
//            session.delete(subject);
//----------------Update Record----------------------
            Subject subject=session.get(Subject.class,2);
            subject.setName("Java Programming");
            session.save(subject);
            transaction.commit();
            session.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
