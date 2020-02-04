package repository;

import model.Picture;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PictureRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save(Picture pic) {
        if (pic.getId() == null) {
            em.persist(pic);
        } else {
            em.merge(pic);
        }
    }

    @Transactional
    public List<Picture> getPicListByProductId(Long productId) {
        return em.createQuery("select p from Picture p where p.product.id = :productId", Picture.class)
                .setParameter("productId", productId)
                .getResultList();
    }


    @Transactional
    public List<Picture> getFirstPicByProductId(Long productId) {
        return em.createQuery("select p from Picture p where p.product.id = :productId", Picture.class)
                .setParameter("productId", productId)
                .setMaxResults(1)
                .getResultList();
    }

}
