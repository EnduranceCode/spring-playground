package guru.springframework.contollers;

import guru.springframework.dto.CheckoutDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

  @RequestMapping("/checkout")
  public String checkoutForm(Model model) {

    model.addAttribute("checkoutDTO", new CheckoutDTO());

    return "checkout-form";
  }

  @PostMapping("/do-checkout")
  public String doCheckout(@Valid CheckoutDTO checkoutDTO, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "checkout-form";
    }

    return "checkout-complete";
  }
}
