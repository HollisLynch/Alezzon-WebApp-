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
    public List<Parametr> getParamList(){
        return em.createQuery("select s from Parametr s", Parametr.class).getResultList();
    }

    @Transactional
    public List<Parametr> findAll(){
        return em.createQuery("from Parametr", Parametr.class).getResultList();
    }

    @Transactional
    public Optional<Parametr> findParamById(Long paramId) {
        var param = em.find(Parametr.class, paramId);
        return Optional.ofNullable(param);
    }


    @Transactional
    public Parametr findParamByName(String paramName) {
        return em.createQuery("select s from Parametr s where s.value = :paramName", Parametr.class)
                .setParameter("paramName", paramName)
                .getSingleResult();
    }

    @Transactional
    public ProductParametr findProductParamByIdByName(String valueParam, Long parameterId, Long productId){
        return em.createQuery("select pp from ProductParametr pp where pp.parameter.id = :parameterId and pp.product.id = :productId and pp.value = :valueParam", ProductParametr.class)
                .setParameter("parameterId", parameterId).setParameter("productId", productId).setParameter("valueParam", valueParam)
                .getSingleResult();
    }

    @Transactional
    public void saveProductParam(ProductParametr parameter) {
        em.persist(parameter);
    }

    @Transactional
    public List<ProductParametr> getProductParamByProductId(Long productId) {
        return em.createQuery("select p from ProductParametr p where p.product.id = :productId", ProductParametr.class)
                .setParameter("productId", productId)
                .getResultList();
    }

    @Transactional
    public List<Parametr> getParamByParamId(Long parametrId) {
        return em.createQuery("select p from Parametr p where p.parametr.id = :parametrId", Parametr.class)
                .setParameter("parametrId", parametrId)
                .getResultList();
    }

    @Transactional
    public List<ProductParametr> getParamByProductId(Long productId) {
        return em.createQuery("select pp from ProductParametr pp join Parametr p on pp.parameter.id = p.id and pp.product.id = :productId", ProductParametr.class)
                .setParameter("productId", productId)
                .getResultList();
    }
}
