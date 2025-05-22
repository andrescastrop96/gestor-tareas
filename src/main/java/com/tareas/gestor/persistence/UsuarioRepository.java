package com.tareas.gestor.persistence;

import com.tareas.gestor.domain.User;
import com.tareas.gestor.domain.repository.UserRepository;
import com.tareas.gestor.persistence.crud.UsuarioCrudRepository;
import com.tareas.gestor.persistence.entity.Usuario;
import com.tareas.gestor.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId)
                .map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return usuarioCrudRepository.findByCorreoElectronico(email)
                .map(mapper::toUser);
    }

}
