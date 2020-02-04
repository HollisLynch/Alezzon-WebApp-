package repository;


import model.Branch;
import model.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class CategoryRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addBranch(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }

    @Transactional
    public void save(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }


    @Transactional
    public List<Category> getCategoryList(){
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Transactional
    public List<Category> findAll(){
        return em.createQuery("from Category", Category.class).getResultList();
    }

    @Transactional
    public Optional<Category> findCategoryById(Long categoryId) {
        var category = em.find(Category.class, categoryId);
        return Optional.ofNullable(category);         //TODO
    }

    @Transactional
    public List<Category> findCategoryByBranchId(Long branchId) {

//        return em.createQuery("select c from Category c where c.section_id = ?1", Category.class)
//                .setParameter(1, sectionId)
//                .getResultList();
        return em.createQuery("select c from Category c where c.branch.id = :branchId", Category.class)
                .setParameter("branchId", branchId)
                .getResultList();
    }

    @Transactional
    public List<Branch> getBranchListFromCategory(){
        return em.createQuery("select distinct s from Branch s join Category c on c.branch.id = s.id", Branch.class).getResultList();
    }

    @Transactional
    public Branch getBranchFromCategory1(Long categoryId){
        return em.createQuery("select s from Branch s where s.id = (select c.branch.id from Category c where c.id = :categoryId)", Branch.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();
    }

    @Transactional
    public  Optional<Branch> getBranchFromCategory(Long categoryId){
        var branch =  em.createQuery("select s from Branch s where s.id = (select c.branch.id from Category c where c.id = :categoryId)", Branch.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();
        return Optional.ofNullable(branch);


    }
}
