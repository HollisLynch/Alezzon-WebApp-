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
            em.persist(branch);
        } else {
            em.merge(branch);
        }
    }


    @Transactional
    public List<Branch> findAll() {
        return em.createQuery("from Branch", Branch.class).getResultList();
    }

    @Transactional
    public Branch findBranchById(Long sectionId) {
        var section = em.find(Branch.class, sectionId);
        return section;
    }


}
