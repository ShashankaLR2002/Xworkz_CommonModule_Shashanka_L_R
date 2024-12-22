package com.xworkz.cmodule.repository;

import com.xworkz.cmodule.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean onsave(PersonEntity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public PersonEntity onlogin(String email, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT p FROM PersonEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);
            List<PersonEntity> result = query.getResultList();

            if (result != null && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public long getCountofName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM PersonEntity p WHERE p.name = :name";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("name", name);

            long count = (long) query.getSingleResult();
            System.out.println("  count for name: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for name: " + name);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }


    @Override
    public long getCountofEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM PersonEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);

            long count = (long) query.getSingleResult();
            System.out.println("  count for Email: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error getting  count for email: " + email);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public long getCountofNumber(String phoneNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM PersonEntity p WHERE p.phoneNumber = :phoneNumber";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("phoneNumber", phoneNumber);

            long count = (long) query.getSingleResult();
            System.out.println("  count for phoneNumber: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error getting  count for phoneNumber: " + phoneNumber);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public long getAlternateEmail(String alternateemail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String Quesrystr = "SELECT COUNT(p) FROM PersonEntity p WHERE p.alternateemail = :alternateemail";
            Query query = entityManager.createQuery(Quesrystr);
            query.setParameter("alternateemail", alternateemail);
            long count = (long) query.getSingleResult();

            System.out.println("Count for Alternate email " + count);
            return count;
        } catch (Exception e) {
            System.out.println("Error getting  count for AlternateEmail : " + alternateemail);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public long getAlternatePhone(String alternatephone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String QueryStr = "SELECT COUNT(p) FROM PersonEntity p WHERE p.alternatephone = :alternatephone";
            Query query = entityManager.createQuery(QueryStr);
            query.setParameter("alternatephone", alternatephone);

            long count = (long) query.getSingleResult();
            System.out.println("count for Alternate Phone" + count);
            return count;

        } catch (Exception e) {
            System.out.println("Error getting  count for Alternatephone : " + alternatephone);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public boolean update(PersonEntity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public PersonEntity findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT p FROM PersonEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);

            List<PersonEntity> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}








