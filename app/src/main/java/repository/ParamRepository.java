package repository;

import model.Parametr;
import model.Product;
import model.ProductParametr;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
    public ProductParametr findProductParam(Long productId, Long paramId) {
        return em.createQuery("select pp from ProductParametr pp  join Parametr par on pp.parameter.id = par.id  join Product p on pp.product.id=p.id where (par.id=:paramId and p.id=:productId)", ProductParametr.class)
                .setParameter("productId", productId)
                .setParameter("paramId", paramId)
                .getSingleResult();
    }


    @Transactional
    public List<ProductParametr> findParamByProductId(Long productId) {
        return em.createQuery("select pp from ProductParametr pp join Parametr p on pp.parameter.id = p.id and pp.product.id = :productId", ProductParametr.class)
                .setParameter("productId", productId)
                .getResultList();
    }

    @Transactional
    public List<ProductParametr> findParamListForProduct(Long productId) {
        return em.createQuery("select pp from ProductParametr pp join Parametr p on pp.parameter.id = p.id and pp.product.id=:productId ", ProductParametr.class)
                .setParameter("productId", productId)
                .getResultList();
    }
}
