package Task.SprintTaskSpringboot.config;

import Task.SprintTaskSpringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(proxyTargetClass = true, prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/403");
        http.authorizeHttpRequests().antMatchers("/CSS/**", "/js/**").permitAll();
        http.formLogin()
                .loginPage("/author").permitAll() //кидает запрос с данныеми
                .usernameParameter("user_email")
                .passwordParameter("user_pass")
                .defaultSuccessUrl("/profile") //если всё хорошо кинет сюда
                .failureUrl("/author?loginPassError"); //если ошибка

        http.logout()
                .logoutUrl("/vyhod")
                .logoutSuccessUrl("/author");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
