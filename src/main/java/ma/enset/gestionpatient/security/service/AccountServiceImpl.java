package ma.enset.gestionpatient.security.service;

import lombok.AllArgsConstructor;
import ma.enset.gestionpatient.security.Repository.AppRoleRepository;
import ma.enset.gestionpatient.security.Repository.AppUserRepository;
import ma.enset.gestionpatient.security.entities.AppRole;
import ma.enset.gestionpatient.security.entities.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service @Transactional @AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser!=null) throw new RuntimeException("User already exist");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Passwords do not match");
        AppUser user=AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return appUserRepository.save(user);
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole=appRoleRepository.findById(role).orElse(null);
        if(appRole!=null) throw new RuntimeException("Role already exist");
        appRole=AppRole.builder()
                .role(role)
                .build();
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findById(role).orElse(null);
        appUser.getRoles().add(appRole);
//        appUserRepository.save(appUser); already transactionelle

    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findById(role).orElse(null);
        appUser.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
