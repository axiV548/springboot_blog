package com.axiv548.springbootblog.web.admin;

import com.axiv548.springbootblog.entity.Types;
import com.axiv548.springbootblog.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * TypeController
 *
 * @date 2020/7/4 23:37
 */

@Configuration
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypesService typesService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        model.addAttribute("page", typesService.listTypes(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("types", new Types());
        return "admin/types-input";
    }


    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("types",typesService.getTypes(id));
        return "admin/types-input";
    }


    @PostMapping("/types")
    public String post(Types types, BindingResult result, RedirectAttributes attributes) {

        Types types1 = typesService.getTypeByName(types.getName());
        if (types1 != null) {
            result.rejectValue("name", "nameError", "重复");
        }

        Types t = typesService.saveTypes(types);
        if (t == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("meesage", "操作成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(Types types, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {

        Types types1 = typesService.getTypeByName(types.getName());
        if (types1 != null) {
            result.rejectValue("name", "nameError", "重复");
        }

        Types t = typesService.updateTypes(id, types);
        if (t == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("meesage", "操作成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id) {
        typesService.deleteTypes(id);
        return "redirect:/admin/types";
    }

}
