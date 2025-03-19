package guru.springframework.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginDTO {

  @NotEmpty
  @Size(min = 2, max = 50)
  private String username;

  @NotEmpty
  @Size(min = 12, max = 60)
  private String password;

  public LoginDTO() {
    super();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
