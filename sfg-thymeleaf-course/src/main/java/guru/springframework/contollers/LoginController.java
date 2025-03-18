package guru.springframework.contollers;

import guru.springframework.dto.LoginDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public String loginForm(Model model) {
    model.addAttribute("loginDTO", new LoginDTO());

    return "login-form";
  }

  @PostMapping("/profile")
  public String profile(@Valid LoginDTO loginDTO, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      return "login-form";
    }

    return "profile";
  }
}
