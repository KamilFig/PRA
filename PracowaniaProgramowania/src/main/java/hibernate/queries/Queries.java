package hibernate.queries;
import hibernate.model.Address;
import hibernate.model.Klienci;
import hibernate.model.Wypozyczenia;
import hibernate.model.Autor;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Klienci> getEmployeeByName(String name) {
        TypedQuery<Klienci> query = entityManager.createQuery(
                "SELECT c FROM Klienci c WHERE c.lastName LIKE :name", Klienci.class);
        return query.setParameter("name", name).getResultList();
    }

    public List<Klienci> getAllEmployeeByPage(int pagenr) {
        //calculate total number
        Query queryTotal = entityManager.createQuery
                ("Select count(f) from Klienci f");
        long countResult = (long)queryTotal.getSingleResult();

        //create query
        Query query = entityManager.createQuery("Select e FROM Klienci e");
        //set pageSize
        int pageSize = 10;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }
    public List<Wypozyczenia> BlacFriday(int salary) {
        TypedQuery<Wypozyczenia> query = entityManager.createQuery(
                "SELECT c FROM Wypozyczenia c ", Wypozyczenia.class);
        return query.getResultList();
    }


}