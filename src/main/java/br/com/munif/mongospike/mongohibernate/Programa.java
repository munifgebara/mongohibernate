package br.com.munif.mongospike.mongohibernate;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;
import org.hibernate.ogm.datastore.infinispan.logging.impl.LoggerFactory;

/**
 *
 * @author munif
 */
public class Programa {

    private static final String JBOSS_TM_CLASS_NAME = "com.arjuna.ats.jta.TransactionManager";

//    public static TransactionManager getTransactionManager() throws Exception {
//        Class<?> tmClass = Programa.class.getClassLoader().loadClass(JBOSS_TM_CLASS_NAME);
//        return (TransactionManager) tmClass.getMethod("transactionManager").invoke(null);
//    }
    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------------_> Inicio");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Breed breed = new Breed();
        breed.setName("Golden");
        em.persist(breed);
        Dog dog=new Dog();
        dog.setBreed(breed);
        dog.setName("Pietra");
        em.persist(dog);
        

        em.getTransaction().commit();
        System.out.println("-----------------------------_> Gravou");
        
        System.out.println("----------->" + em.find(Dog.class, dog.getId()));

        emf.close();
        
        System.out.println("-----------------------------_> Fim");

    }
}
