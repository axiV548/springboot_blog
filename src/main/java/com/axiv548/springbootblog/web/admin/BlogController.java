package com.axiv548.springbootblog.web.admin;

import com.axiv548.springbootblog.entity.Blog;
import com.axiv548.springbootblog.entity.User;
import com.axiv548.springbootblog.service.BlogService;
import com.axiv548.springbootblog.service.TagService;
import com.axiv548.springbootblog.service.TypesService;
import com.axiv548.springbootblog.vo.BlogQuery;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * BlogController
 *
 * @date 2020/7/4 22:32
 */

@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT = "admin/input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypesService typesService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 10, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model) {
        model.addAttribute("types", typesService.listTypes());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 10, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }


    @GetMapping("/blogs/input")
    public String input(Model model) {
        setTypesAndTag(model);
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    private void setTypesAndTag(Model model) {
        model.addAttribute("types", typesService.listTypes());
        model.addAttribute("tags", tagService.listTag());

    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        setTypesAndTag(model);
        Blog blog = blogService.getBlog(id);
        blog.init();
        model.addAttribute("blog", blog);
        return INPUT;
    }

    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {

        blog.setUser((User) session.getAttribute("user"));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        blog.setTypes(typesService.getTypes(blog.getTypes().getId()));
        Blog b;
        if (blog.getId() == null) {
            b = blogService.saveBlog(blog);
        } else {
            b = blogService.updateBlog(blog.getId(), blog);
        }

        if (b == null) {
            attributes.addFlashAttribute("message", "操作成功");
        } else {
            attributes.addFlashAttribute("message", "操作失败");
        }
        return REDIRECT_LIST;
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return REDIRECT_LIST;
    }


}
