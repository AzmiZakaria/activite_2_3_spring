package ma.enset.gestionpatient.security;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
// @EnableMethodSecurity
public class SecurityConfig {
    private PasswordEncoder passwordEncoder;
    private UserDetailsService userDetailsService;

//    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
    return new JdbcUserDetailsManager(dataSource);
    }
//    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER","ADMIN").build(),
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/user/index"))
                .rememberMe(Customizer.withDefaults())
                .authorizeHttpRequests(ar -> ar.requestMatchers("/webjars/**", "/css/**", "/js/**", "/images/**").permitAll())
                .authorizeHttpRequests(ar -> ar.requestMatchers("/admin/**").hasRole("ADMIN"))
                .authorizeHttpRequests(ar -> ar.requestMatchers("/user/**").hasRole("USER"))
                .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
                .userDetailsService(userDetailsService)
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/notAuthenticated")
                );
        return httpSecurity.build();
    }
}
