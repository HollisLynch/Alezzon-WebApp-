package repository;


import model.Branch;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class BranchRepository {
    @PersistenceContext
    EntityManager em;


    @Transactional
    public void save(Branch section) {
        if (section.getId() == null) {
            em.persist(section);
        } else {
            em.merge(section);
        }
    }

    @Transactional
    public List<Branch> getBranchList(){
        return em.createQuery("select s from Branch s", Branch.class).getResultList();
    }

    @Transactional
    public List<Branch> findAll(){
        return em.createQuery("from Branch", Branch.class).getResultList();
    }

    @Transactional
    public Optional<Branch> findBranchById(Long sectionId) {
        var section = em.find(Branch.class, sectionId);
        return Optional.ofNullable(section);
    }


    @Transactional
    public Branch findBranchByName(String sectionName) {
        return em.createQuery("select s from Branch s where s.name = :sectionName", Branch.class)
                .setParameter("sectionName", sectionName)
                .getSingleResult();
    }


}
