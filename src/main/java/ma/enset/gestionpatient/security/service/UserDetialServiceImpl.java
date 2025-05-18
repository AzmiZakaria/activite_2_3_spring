package ma.enset.gestionpatient.security.service;

import lombok.AllArgsConstructor;
import ma.enset.gestionpatient.security.Repository.AppRoleRepository;
import ma.enset.gestionpatient.security.Repository.AppUserRepository;
import ma.enset.gestionpatient.security.entities.AppRole;
import ma.enset.gestionpatient.security.entities.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserDetialServiceImpl implements UserDetailsService {
    private IAccountService accountService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(username);
        if(appUser == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }

        String[] roles = appUser.getRoles()
                .stream()
                .map(role -> role.getRole())
                .toArray(String[]::new);

        UserDetails userDetails = User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles)
                .build();

        return userDetails;
    }
}
