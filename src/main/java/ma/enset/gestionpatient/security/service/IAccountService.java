package ma.enset.gestionpatient.security.service;

import ma.enset.gestionpatient.security.entities.AppRole;
import ma.enset.gestionpatient.security.entities.AppUser;

public interface IAccountService {
    AppUser addNewUser(String username, String password, String email,String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
