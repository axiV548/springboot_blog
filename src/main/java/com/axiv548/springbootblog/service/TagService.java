package com.axiv548.springbootblog.service;

import com.axiv548.springbootblog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * TagsService
 *
 * @date 2020/7/9 16:24
 */
public interface TagService {

    Tag saveTag(Tag Tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Tag updateTag(Long id, Tag Tag);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    void deleteTag(Long id);
}
