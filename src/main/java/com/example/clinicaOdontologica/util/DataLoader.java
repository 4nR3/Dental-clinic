package com.example.clinicaOdontologica.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader{
/*
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public DataLoader(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String contrasena=bCryptPasswordEncoder.encode("a");
        String contrasena2=bCryptPasswordEncoder.encode("a");

        System.out.println(contrasena);

        iUsuarioRepository.save(new Usuario("Andre","4nR3","email@mail.com",contrasena,RolesUsuario.ADMIN));
        iUsuarioRepository.save(new Usuario("Andre","4nR3","mail@mail.com",contrasena2,RolesUsuario.USER));

    }*/
}
