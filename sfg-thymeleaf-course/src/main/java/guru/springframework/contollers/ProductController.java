package guru.springframework.contollers;

import guru.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/product")
  public String getProduct() {
    return "redirect:/";
  }

  @RequestMapping("/product/{id}")
  public String getProductByID(@PathVariable Integer id, Model model) {

    model.addAttribute("product", productService.getProduct(id));

    return "product";
  }
}
