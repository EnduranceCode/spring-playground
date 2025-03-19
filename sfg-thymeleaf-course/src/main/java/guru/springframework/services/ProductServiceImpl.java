package guru.springframework.services;

import guru.springframework.domain.Author;
import guru.springframework.domain.Product;
import guru.springframework.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

  private Map<Integer, Product> productMap;

  public ProductServiceImpl() {
    loadProducts();
  }

  @Override
  public Product getProduct(Integer id) {
    return productMap.get(id);
  }

  @Override
  public List<Product> getProducts() {
    return new ArrayList<>(productMap.values());
  }

  private void loadProducts() {
    Author jt = new Author();
    jt.setId(1);
    jt.setFirstName("John");
    jt.setLastName("Thompson");
    jt.setImage("instructor_jt.jpg");

    ProductCategory springIntroCategory = new ProductCategory();
    springIntroCategory.setId(1);
    springIntroCategory.setCategory("Spring Introduction");

    ProductCategory springCoreCategory = new ProductCategory();
    springCoreCategory.setId(2);
    springCoreCategory.setCategory("Spring Core");

    ProductCategory springBootCategory = new ProductCategory();
    springBootCategory.setId(3);
    springBootCategory.setCategory("Spring Boot");

    ProductCategory thymeleafCategory = new ProductCategory();
    thymeleafCategory.setId(4);
    thymeleafCategory.setCategory("Thymeleaf");

    ProductCategory geapCategory = new ProductCategory();
    geapCategory.setId(5);
    geapCategory.setCategory("G. E. A. P.");

    productMap = new HashMap<>();
    productMap.put(1, getSpringIntro(jt, springIntroCategory, springBootCategory));
    productMap.put(2, getSpringCoreUltimate(jt, springCoreCategory, springBootCategory));
    productMap.put(3, getThymeleaf(jt, thymeleafCategory));
    productMap.put(4, getSpringCore(jt, springCoreCategory, springBootCategory));
    productMap.put(5, getSpringCoreAdvanced(jt, springCoreCategory, springBootCategory));
    productMap.put(
        6, getSpringCoreDevOps(jt, springCoreCategory, springBootCategory, geapCategory));
  }

  private static Product getSpringIntro(
      Author jt, ProductCategory springIntroCategory, ProductCategory springBootCategory) {

    Product springIntro = new Product();
    springIntro.setId(1);
    springIntro.setCourseName("Introduction to Spring");
    springIntro.setCourseSubtitle("Start Learning Spring!");
    springIntro.setAuthor(jt);
    springIntro.setDescription("""
        <p>Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used \
        framework in the enterprise today. Major companies all over the world are hiring programmers who know \
        the Spring Framework.</p>
        <p>My Introduction Spring Framework Tutorial is designed to give you an introduction to the \
        Spring Framework. This course is written for beginners. Ideally before taking the course, \
        you should already have a foundation with the Java programming language. You don't need to be an \
        expert in Java, but you should the basics of Object Oriented Programming with Java.</p>
        <p>You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage \
        Dependency Injection. Next in my course, I will walk you step by step through building your very first \
        Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to \
        jumpstart your Spring Framework project. Ideally, you can follow along and create your own \
        Spring project. I know it can be frustrating to follow along in a course and run into errors. \
        So don't worry, I have the complete source code examples in Git for you to checkout and use.</p>
        """);
    springIntro.setPrice(new BigDecimal("0"));
    springIntro.setImageUrl("SpringIntroThumb.png");
    springIntro.getProductCategories().add(springIntroCategory);
    springIntro.getProductCategories().add(springBootCategory);
    return springIntro;
  }

  private static Product getSpringCoreUltimate(
      Author jt, ProductCategory springCoreCategory, ProductCategory springBootCategory) {
    Product springCoreUltimate = new Product();
    springCoreUltimate.setId(2);
    springCoreUltimate.setCourseName("Spring Core Ultimate");
    springCoreUltimate.setCourseSubtitle("Ultimate Bundle of Spring Core!");
    springCoreUltimate.setAuthor(jt);
    springCoreUltimate.setDescription("""
        <p>Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used \
        framework in the enterprise today. Major companies all over the world are hiring programmers \
        who know the Spring Framework.</p>
        <p>My Introduction Spring Framework Tutorial is designed to give you an introduction to the \
        Spring Framework. This course is written for beginners. Ideally before taking the course, you should \
        already have a foundation with the Java programming language. You don't need to be an expert in Java, \
        but you should th basics of Object Oriented Programming with Java.</p>
        <p>You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage \
        Dependency Injection. Next in my course, I will walk you step by step through building your very first \
        Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to \
        jumpstart yourSpring Framework project. Ideally, you can follow along and create your own Spring \
        project. I known it can be frustrating to follow along in a course and run into errors. So don't worry, \
        I have the complete source code examples n Git for you to checkout and use.</p>
        """);
    springCoreUltimate.setPrice(new BigDecimal("147"));
    springCoreUltimate.setImageUrl("SpringCoreUltimateThumb.png");
    springCoreUltimate.getProductCategories().add(springCoreCategory);
    springCoreUltimate.getProductCategories().add(springBootCategory);
    return springCoreUltimate;
  }

  private static Product getThymeleaf(Author jt, ProductCategory thymeleafCategory) {
    Product thymeleaf = new Product();
    thymeleaf.setId(3);
    thymeleaf.setCourseName("Thymeleaf");
    thymeleaf.setCourseSubtitle("Thymeleaf and Spring!");
    thymeleaf.setAuthor(jt);
    thymeleaf.setDescription("""
        <p>Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used \
        framework in the enterprise today. Major companies all over the world are hiring programmers who know \
        the Spring Framework.</p>
        <p>My Introduction Spring Framework Tutorial is designed to give you an introduction to the \
        Spring Framework. This course is written for beginners. Ideally before taking the course, you should \
        already have a foundation with the Java programming language. You don't need to be an expert in Java, \
        but you should the basics of Object Oriented Programming with Java.</p>
        <p>You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage \
        Dependency Injection. Next in my course, I will walk you step by step through building your very first \
        Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to \
        jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring \
        project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, \
        I have the complete source code examples in Git for you to checkout and use.</p>
        """);
    thymeleaf.setPrice(new BigDecimal("15"));
    thymeleaf.setImageUrl("ThymeleafThumb.png");
    thymeleaf.getProductCategories().add(thymeleafCategory);
    return thymeleaf;
  }

  private static Product getSpringCore(
      Author jt, ProductCategory springCoreCategory, ProductCategory springBootCategory) {
    Product springCore = new Product();
    springCore.setId(4);
    springCore.setCourseName("Spring Core");
    springCore.setCourseSubtitle("Spring Core - mastering Spring!");
    springCore.setAuthor(jt);
    springCore.setDescription("""
        <p>Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used \
        framework in the enterprise today. Major companies all over the world are hiring programmers who know \
        the Spring Framework.</p>
        <p>My Introduction Spring Framework Tutorial is designed to give you an introduction to the \
        Spring Framework. This course is written for beginners. Ideally before taking the course, \
        you should already have a foundation with the Java programming language. You don't need to be \
        an expert in Java, but you should the basics of Object Oriented Programming with Java.</p>
        <p>You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage \
        Dependency Injection. Next in my course, I will walk you step by step through building your very first \
        Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to \
        jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring \
        project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, \
        I have the complete source code examples in Git for you to checkout and use.</p>
        """);
    springCore.setPrice(new BigDecimal("99"));
    springCore.setImageUrl("SpringCoreThumb.png");
    springCore.getProductCategories().add(springCoreCategory);
    springCore.getProductCategories().add(springBootCategory);
    return springCore;
  }

  private static Product getSpringCoreAdvanced(
      Author jt, ProductCategory springCoreCategory, ProductCategory springBootCategory) {
    Product springCoreAdv = new Product();
    springCoreAdv.setId(5);
    springCoreAdv.setCourseName("Spring Core Advanced");
    springCoreAdv.setCourseSubtitle("Advanced Spring Core!");
    springCoreAdv.setAuthor(jt);
    springCoreAdv.setDescription("""
        <p>Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used \
        framework in the enterprise today. Major companies all over the world are hiring programmers who know \
        the Spring Framework.</p>
        <p>My Introduction Spring Framework Tutorial is designed to give you an introduction to the \
        Spring Framework. This course is written for beginners. Ideally before taking the course, \
        you should already have a foundation with the Java programming language. You don't need to be an \
        expert in Java, but you should the basics of Object Oriented Programming with Java.</p>
        <p>You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage \
        Dependency Injection. Next in my course, I will walk you step by step through building your very first \
        Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to \
        jumpstart your Spring Framework project. Ideally, you can follow along and create your own Spring \
        project. I know it can be frustrating to follow along in a course and run into errors. So don't worry, \
        I have the complete source code examples in Git for you to checkout and use.</p>
        """);
    springCoreAdv.setPrice(new BigDecimal("99"));
    springCoreAdv.setImageUrl("SpringCoreAdvancedThumb.png");
    springCoreAdv.getProductCategories().add(springCoreCategory);
    springCoreAdv.getProductCategories().add(springBootCategory);
    return springCoreAdv;
  }

  private static Product getSpringCoreDevOps(
      Author jt, ProductCategory springCoreCategory, ProductCategory springBootCategory,
      ProductCategory geapCategory
  ) {
    Product springCoreDevOps = new Product();
    springCoreDevOps.setId(6);
    springCoreDevOps.setCourseName("Spring Core Dev-Ops");
    springCoreDevOps.setCourseSubtitle("Deploying Spring in the Enterprise and the cloud!");
    springCoreDevOps.setAuthor(jt);
    springCoreDevOps.setDescription("""
        <p>Why would you want to learn about the Spring Framework? Simple, Spring is the most widely used \
        framework in the enterprise today. Major companies all over the world are hiring programmers who know \
        the Spring Framework.</p>
        <p>My Introduction Spring Framework Tutorial is designed to give you an introduction to the \
        Spring Framework. This course is written for beginners. Ideally before taking the course, you should \
        already have a foundation with the Java programming language. You don't need to be an expert in Java, \
        but you should the basics of Object Oriented Programming with Java.</p>
        <p>You will learn what Dependency Injection is, and how Spring uses Inversion of Control to leverage \
        Dependency Injection. Next in my course, I will walk you step by step through building your very first \
        Spring Framework application. I'll show you hot to use the Spring Initializer and Spring Boot to \
        jumpstart your Spring Framework project. Ideally, you can follow along and create your own \
        Spring project. I know it can be frustrating to follow along in a course and run into errors. \
        So don't worry, I have the complete source code examples in Git for you to checkout and use.</p>
        """);
    springCoreDevOps.setPrice(new BigDecimal("15"));
    springCoreDevOps.setImageUrl("SpringCoreDevOpsThumb.png");
    springCoreDevOps.getProductCategories().add(springCoreCategory);
    springCoreDevOps.getProductCategories().add(springBootCategory);
    springCoreDevOps.getProductCategories().add(geapCategory);
    return springCoreDevOps;
  }
}
