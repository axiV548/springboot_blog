package com.axiv548.springbootblog.sql;

import com.axiv548.springbootblog.entity.Types;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TypesRepository
 *
 * @date 2020/7/4 23:29
 */
public interface TypesRepository extends JpaRepository<Types, Long> {

    Types findByName(String name);

    @Query("select t from Types t")
    List<Types> findTop(Pageable pageable);

}
