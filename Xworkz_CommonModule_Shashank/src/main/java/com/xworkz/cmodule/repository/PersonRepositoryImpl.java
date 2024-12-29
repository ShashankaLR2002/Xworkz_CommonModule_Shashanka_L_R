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
            Query query = entityManager.createNamedQuery("getPersonEntitylistByEmail");
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
            Query query = entityManager.createNamedQuery("getPersonEntitycountbyname");
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
            Query query = entityManager.createNamedQuery("getPersonEntitycountByEmail");
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
            Query query = entityManager.createNamedQuery("getPersonEntitycountbyphoneNumber");

            Long phoneNumberRef = Long.valueOf(phoneNumber);
            query.setParameter("phoneNumber", phoneNumberRef);

            long count = (long) query.getSingleResult();
            System.out.println("Count for phoneNumber: " + count);
            return count;

        } catch (NumberFormatException e) {
            System.err.println("Invalid phoneNumber format: " + phoneNumber);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error getting count for phoneNumber: " + phoneNumber);
            e.printStackTrace();
        } finally {

            entityManager.close();

        }
        return 0;
    }


    @Override
    public long getCountAlternateEmail(String alternateemail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getPersonEntitycountbyalternateemail");
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
    public long getCountofAlternatePhone(String alternatephone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getPersonEntitycountbyalternatephone");
            Long alternatephoneref = Long.valueOf(alternatephone);
            query.setParameter("alternatephone", alternatephoneref);

            long count = (long) query.getSingleResult();
            System.out.println("Count for alternatePhone: " + count);
            return count;

        } catch (Exception e) {
            System.err.println("Error getting count for alternatePhone: " + alternatephone);
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
            Query query = entityManager.createNamedQuery("getPersonEntitylistbyemailforResetpassword");
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








