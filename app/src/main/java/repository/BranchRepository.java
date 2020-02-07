package repository;


import model.Branch;

import javax.enterprise.context.ApplicationScoped;
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
    public void save(Branch branch) {

        if (branch.getId() == null) {
            try {
                em.persist(branch);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        else {

            try {
                em.merge(branch);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    @Transactional
    public List<Branch> findAll(){
        return em.createQuery("from Branch", Branch.class).getResultList();
    }

    @Transactional
    public Branch findBranchById(Long sectionId) {
        var section = em.find(Branch.class, sectionId);
        return section;
    }


    @Transactional
    public Branch findBranchByName(String sectionName) {
        return em.createQuery("select s from Branch s where s.name = :sectionName", Branch.class)
                .setParameter("sectionName", sectionName)
                .getSingleResult();
    }


}
