package request.edit;

public class EditPictureRequest {

    private Long id;
    private Long productId;
    private String link;

    public EditPictureRequest() {
    }

    public EditPictureRequest(Long id, Long productId, String link) {
        this.id = id;
        this.productId = productId;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
