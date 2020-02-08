package repository;

import model.Category;
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
    public Product findProductById1(Long productId) {
        var product = em.find(Product.class, productId);
        return product;
    }


    @Transactional
    public void save(Product product) {
        if (product.getId() == null)
            em.persist(product);
        else
            em.merge(product);
    }

    @Transactional
    public void saveParametersToProduct(ProductParametr productParametr) {
            em.persist(productParametr);
    }

    @Transactional
    public Category findCategoryByProductId(Long productId) {
        return em.createQuery("select c from Category c where c.id in(select p.category.id from Product p where p.id = :productId)", Category.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }



    @Transactional
    public List<Product> getProductListByOwnerId(Long ownerId) {
        return em.createQuery("select p from Product p where p.user = :ownerId", Product.class)
                .setParameter("ownerId", ownerId)
                .getResultList();

    }

    @Transactional
    public Product getProductById(Long productId) {
        return em.createQuery("select p from Product p where p.id = :productId", Product.class)
                .setParameter("productId", productId)
                .getSingleResult();

    }

    @Transactional
    public Category findCategoryById(Long catId) {
        return em.createQuery("select c from Category c where c.id = :catId", Category.class)
                .setParameter("catId", catId)
                .getSingleResult();

    }

    @Transactional
    public List<Product> findAll(){
        return em.createQuery("from Product", Product.class).getResultList();
    }


}
