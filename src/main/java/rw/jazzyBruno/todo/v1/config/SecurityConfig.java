package rw.jazzyBruno.todo.v1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
        new User(
                "jazzybruno45@gmail.com",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        ),

              new User(
                "axellemugisha@gmail.com",
                        "password",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
      http.authorizeHttpRequests().anyRequest().authenticated()
              .and()
              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
              .authenticationProvider(authenticationProvider())
              .addFilterBefore(jwtAuthFilter , UsernamePasswordAuthenticationFilter.class);
      return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
         daoAuthenticationProvider.setUserDetailsService(userDetailsService());
         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        // TODO: 2/24/2023 learn how to incrypt the password

        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return APPLICATION_USERS
                        .stream()
                        .filter(u -> u.getUsername().equals(email))
                        .findFirst()
                        .orElseThrow(() -> new UsernameNotFoundException("The user was not found"));
            }
        };
    }
}
