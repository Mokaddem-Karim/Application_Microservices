package authenticationservice.auth;

import authenticationservice.user.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class applicationConfig {

    private final userRepository repository;
    @Bean
    public UserDetailsService userDetailsService(){
        return username ->repository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("user not found")) ;
    }

    //to fetch userDetail..
   @Bean
    public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();

       authProvider.setUserDetailsService(userDetailsService());
       authProvider.setPasswordEncoder(paswordEncoder());
       return authProvider;
    }

    @Bean
    public PasswordEncoder paswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
