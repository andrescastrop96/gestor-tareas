package com.tareas.gestor.persistence.mapper;

import com.tareas.gestor.domain.Category;
import com.tareas.gestor.persistence.entity.Categoria;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "descripcion", target = "category")
    @Mapping(source = "estado", target = "active")
    Category toCategory(Categoria categoria);

    List<Category> toCategories(List<Categoria> categorias);

    @InheritInverseConfiguration
    Categoria toCategoria(Category category);
}





