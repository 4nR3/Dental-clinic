package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.repository.usuario.IUsuarioRepository;
import com.example.clinicaOdontologica.entity.usuario.RolesUsuario;
import com.example.clinicaOdontologica.entity.usuario.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserTest {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Test
    @Order(1)
    public void cargarPacientes(){
        try{

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String contrasena=bCryptPasswordEncoder.encode("admin");
            String contrasena2=bCryptPasswordEncoder.encode("user");

            System.out.println(contrasena);

            iUsuarioRepository.save(new Usuario("Admin","Admin","admin@mail.com",contrasena, RolesUsuario.ADMIN));
            iUsuarioRepository.save(new Usuario("Usuario","user","user@mail.com",contrasena2,RolesUsuario.USER));



            logger.info("Usuarios creados con exito");
        }
        catch (Exception e){
            logger.error(e);
            logger.error("Hubo un error al cargar los datos");
        }

    }
}
