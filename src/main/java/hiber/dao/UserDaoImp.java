package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User getUserByCar(Car car) {
      List<User> users;
      Session session = sessionFactory.openSession();
      try {
         Transaction transaction = session.beginTransaction();
         users = (List<User>) session.createQuery("from User where car =:car")
                 .setParameter("car", car).list();
         transaction.commit();
      } finally {
         session.close();
      }
      return users.isEmpty() ? null : users.get(0);
   }

}
