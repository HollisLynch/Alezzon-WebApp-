package repository;

import model.Picture;
import model.Product;
import model.ProductParametr;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {
    @PersistenceContext
    EntityManager em;


    @Transactional
    public void save(Product product) {
        if (product.getId() == null)
            em.persist(product);
        else
            em.merge(product);
    }

    @Transactional
    public void saveParametersToProduct(ProductParametr productParametr) {
        if (productParametr.getParameter() == null && productParametr.getProduct() == null)
            em.persist(productParametr);
        else
            em.merge(productParametr);
    }

    @Transactional
    public void saveParams(ProductParametr productParametr) {
        em.persist(productParametr);
    }

    @Transactional
    public void savePicToProduct(Picture picture) {
        em.persist(picture);
    }

    @Transactional
    public List<Product> findProductListByOwnerId(Long user) {
        return em.createQuery("select p from Product p where p.user = :user", Product.class)
                .setParameter("user", user)
                .getResultList();

    }

    @Transactional
    public Product findProductById(Long productId) {
        return em.createQuery("select p from Product p where p.id = :productId", Product.class)
                .setParameter("productId", productId)
                .getSingleResult();

    }


    @Transactional
    public ProductParametr findProductParamByParamIdAndProduct(Long parameterId, Long productId) {
        return em.createQuery("select pp from ProductParametr pp where pp.parameter.id = :parameterId and pp.product.id = :productId", ProductParametr.class)
                .setParameter("parameterId", parameterId).setParameter("productId", productId)
                .getSingleResult();
    }

    @Transactional
    public List<Product> findAll() {
        return em.createQuery("from Product", Product.class).getResultList();
    }
}
