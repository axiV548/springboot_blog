package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.NotFoundException;
import com.axiv548.springbootblog.entity.Types;
import com.axiv548.springbootblog.sql.TypesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * TypesServiceImpl
 *
 * @date 2020/7/4 23:27
 */

@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    private TypesRepository typesRepository;

    @Transactional
    @Override
    public Types saveTypes(Types types) {

        return typesRepository.save(types);
    }

    @Transactional
    @Override
    public Types getTypes(Long id) {

        return typesRepository.findById(id).orElse(null);
    }

    @Override
    public Types getTypeByName(String name) {
        return typesRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Types> listTypes(Pageable pageable) {

        return typesRepository.findAll(pageable);
    }

    @Override
    public List<Types> listTypes() {
        return typesRepository.findAll();
    }

    @Override
    public List<Types> listTypesTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable= PageRequest.of(0, size, sort);
        return typesRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Types updateTypes(Long id, Types types) {
        Types t = typesRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(types, t);
        return typesRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTypes(Long id) {
        typesRepository.deleteById(id);

    }

}
