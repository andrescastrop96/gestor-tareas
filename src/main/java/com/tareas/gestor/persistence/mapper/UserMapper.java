package com.tareas.gestor.persistence.mapper;

import com.tareas.gestor.domain.User;
import com.tareas.gestor.persistence.entity.Usuario;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombre", target = "firstName"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "estado", target = "active")
    })
    User toUser(Usuario usuario);

    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
