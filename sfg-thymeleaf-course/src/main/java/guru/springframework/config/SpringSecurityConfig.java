package guru.springframework.config;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.builder()
        .username("admin")
        .password(passwordEncoder().encode("admin"))
        .roles("ADMIN", "USER")
        .build());
    manager.createUser(User.builder()
        .username("user")
        .password(passwordEncoder().encode("user"))
        .roles("USER")
        .build());
    return manager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize -> authorize.requestMatchers(
                antMatcher("/"), antMatcher("/index/**"), antMatcher("/product/**"),
                antMatcher("/checkout"), antMatcher("/do-checkout"), antMatcher("/logout-success")
            )
            .permitAll()
            .requestMatchers(antMatcher("/login"), antMatcher("/logout"))
            .permitAll()
            .requestMatchers(antMatcher("/css/**"), antMatcher("/img/**"))
            .permitAll()
            .anyRequest()
            .authenticated())
        .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/").permitAll())
        .logout(logout -> logout.deleteCookies("remove")
            .invalidateHttpSession(true)
            .logoutUrl("/logout")
            .logoutSuccessUrl("/logout-success")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")));
    return http.build();
  }
}
