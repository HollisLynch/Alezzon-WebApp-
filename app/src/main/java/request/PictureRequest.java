package request;

public class PictureRequest {
    private Long id;
    private String link;
    private Long productId;

    public PictureRequest() {
    }

    public PictureRequest(Long id, String link, Long productId) {
        this.id = id;
        this.link = link;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
