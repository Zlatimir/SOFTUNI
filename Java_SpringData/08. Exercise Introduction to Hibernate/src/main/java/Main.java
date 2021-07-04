<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softuni").createEntityManager();

        Engine engine = new Engine(em);
        engine.run();

        em.close();
    }
}
=======
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("softuni").createEntityManager();

        Engine engine = new Engine(em);
        engine.run();

        em.close();
    }
}
>>>>>>> f8966932183f5bd3236c5ff8b5dd0544494388e1
