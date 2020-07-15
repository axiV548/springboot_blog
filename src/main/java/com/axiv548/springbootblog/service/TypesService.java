package com.axiv548.springbootblog.service;


import com.axiv548.springbootblog.entity.Types;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * TypeService
 *
 * @date 2020/7/4 23:23
 */
public interface TypesService {

    Types saveTypes(Types types);

    Types getTypes(Long id);

    Types getTypeByName(String name);

    Page<Types> listTypes(Pageable pageable);

    List<Types> listTypes();

    List<Types> listTypesTop(Integer size);

    Types updateTypes(Long id, Types types);

    void deleteTypes(Long id);
}
