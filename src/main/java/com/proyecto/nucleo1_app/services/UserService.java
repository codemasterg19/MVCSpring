package com.proyecto.nucleo1_app.services;

import com.proyecto.nucleo1_app.models.Role;
import com.proyecto.nucleo1_app.models.User;
import com.proyecto.nucleo1_app.repository.RoleRepository;
import com.proyecto.nucleo1_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    public User save(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        //Buscar rol sino crearlo
        Role userRole = roleRepository.findByName("ROLE_ADMIN").
                orElseGet(() ->{
                    Role newRole = new Role();
                    newRole.setName("ROLE_ADMIN");
                    return  roleRepository.save(newRole);
                });
        user.getRoles().add(userRole);
        return this.repository.save(user);
    }
}
