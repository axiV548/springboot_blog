package com.axiv548.springbootblog.web;

import com.axiv548.springbootblog.entity.Types;
import com.axiv548.springbootblog.service.BlogService;
import com.axiv548.springbootblog.service.TypesService;
import com.axiv548.springbootblog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * TypeShowController
 *
 * @date 2020/7/16 21:58
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypesService typesService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable, @PathVariable Long id, Model model) {

        List<Types> types = typesService.listTypesTop(10000);
        if (id == -1) {
            id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types", types);
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        model.addAttribute("activeTypeId", id);
        return "types";
    }


}
