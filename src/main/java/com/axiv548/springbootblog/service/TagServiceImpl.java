package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.NotFoundException;
import com.axiv548.springbootblog.entity.Tag;
import com.axiv548.springbootblog.sql.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * TagServiceImpl
 *
 * @date 2020/7/9 16:35
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag Tag) {

        return tagRepository.save(Tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {

        return tagRepository.findById(id).get();
    }

    @Override
    public Tag getTagByName(String name) {

        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag Tag) {
        Tag t = tagRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(Tag, t);
        return tagRepository.save(t);

    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {

        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }


    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllById(convertTolist(ids));
    }
    private List<Long> convertTolist(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }


    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
