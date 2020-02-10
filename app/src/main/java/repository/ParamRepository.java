package repository;

import model.Parametr;
import model.ProductParametr;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ParamRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save(Parametr param) {
        if (param.getId() == null) {
            em.persist(param);
        } else {
            em.merge(param);
        }
    }

    @Transactional
    public List<Parametr> findAll() {
        return em.createQuery("select s from Parametr s", Parametr.class).getResultList();
    }


    @Transactional
    public Parametr findParamById(Long paramId) {
        Parametr param = em.find(Parametr.class, paramId);
        return param;
    }


    @Transactional
    public Parametr findParamByName(String paramName) {
        return em.createQuery("select s from Parametr s where s.value = :paramName", Parametr.class)
                .setParameter("paramName", paramName)
                .getSingleResult();
    }

    @Transactional
    public ProductParametr findProductParamById(Long id) {
        return em.createQuery("select pp from ProductParametr pp where pp.product.id = :id", ProductParametr.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void saveProductParam(ProductParametr parameter) {
        em.persist(parameter);
    }


    @Transactional
    public List<ProductParametr> getParamByProductId(Long productId) {
        return em.createQuery("select pp from ProductParametr pp join Parametr p on pp.parameter.id = p.id and pp.product.id = :productId", ProductParametr.class)
                .setParameter("productId", productId)
                .getResultList();
    }
}
