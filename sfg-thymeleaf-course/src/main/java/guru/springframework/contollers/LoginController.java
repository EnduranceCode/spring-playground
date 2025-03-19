package guru.springframework.contollers;

import guru.springframework.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public String loginForm(Model model) {
    model.addAttribute("loginDTO", new LoginDTO());

    return "login-form";
  }

  @RequestMapping("logout-success")
  public String yourLoggedOut() {
    return "logout-success";
  }
}
