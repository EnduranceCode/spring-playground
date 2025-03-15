package guru.springframework.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

  private Integer id;
  private String courseName;
  private String courseSubtitle;
  private Author author;
  private String description;
  private BigDecimal price;
  private List<ProductCategory> productCategories = new ArrayList<>();
  private String imageUrl;

  public Product() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseSubtitle() {
    return courseSubtitle;
  }

  public void setCourseSubtitle(String courseSubtitle) {
    this.courseSubtitle = courseSubtitle;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public List<ProductCategory> getProductCategories() {
    return productCategories;
  }

  public void setProductCategories(List<ProductCategory> productCategories) {
    this.productCategories = productCategories;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
