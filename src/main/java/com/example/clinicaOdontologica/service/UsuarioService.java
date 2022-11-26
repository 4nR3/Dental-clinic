package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.usuario.RolesUsuario;
import com.example.clinicaOdontologica.entity.usuario.Usuario;
import com.example.clinicaOdontologica.repository.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {


    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return iUsuarioRepository.findByEmail(email).get();
    }

    public ResponseEntity<String> crearUsuario(Usuario usuario) {

        if(usuario.getUsername()==null || usuario.getEmail()==null || usuario.getPassword()==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uno o más campos vacios");

        Usuario u = (Usuario) loadUserByUsername(usuario.getEmail());

        if(u!=null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Mail ya registrado");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuario.setRolesUsuario(RolesUsuario.USER);

        iUsuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha enviado un correo a su casilla de correos");

    }

}
