package com.durao.demogenerics.services;

import com.durao.demogenerics.util.Convertible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface GenericService<T extends Convertible<DTO>, DTO, ID> {
    JpaRepository<T, ID> getRepository();

    default DTO findById(ID id) {
        Optional<T> result = getRepository().findById(id);
        return result.get().convert();
    }

    default List<DTO> findAll() {
        List<T> list = getRepository().findAll();
        return list.stream().map(T::convert).collect(Collectors.toList());
    }
}
