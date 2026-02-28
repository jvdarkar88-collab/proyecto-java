package com.educacion.recursos.controlador;

import com.educacion.recursos.modelo.Recurso;
import com.educacion.recursos.repositorio.RecursoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recursos")
public class RecursoControlador {
    private final RecursoRepositorio repo;

    public RecursoControlador(RecursoRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "recursos-lista";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("resource", new Recurso());
        return "recursos-formulario";
    }

    @PostMapping
    public String create(@ModelAttribute Recurso resource) {
        if (resource.getDisponible() == null) {
            resource.setDisponible(false);
        }
        repo.save(resource);
        return "redirect:/recursos";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Recurso resource = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("resource", resource);
        return "recursos-formulario";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Recurso resource) {
        resource.setId(id);
        if (resource.getDisponible() == null) {
            resource.setDisponible(false);
        }
        repo.save(resource);
        return "redirect:/recursos";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/recursos";
    }

@GetMapping("/alumnos")
    public String listAlumnos(Model model) {
        model.addAttribute("alumnos", repo.findAll());
        return "alumnos-lista";
    }

    @GetMapping("/alumnos/new")
    public String formAlumno(Model model) {
        model.addAttribute("alumno", new Recurso());
        return "alumnos-formulario";
    }

    @PostMapping("/alumnos")
    public String createAlumno(@ModelAttribute Recurso alumno) {
        repo.save(alumno);
        return "redirect:/recursos/alumnos";
    }

    @GetMapping("/alumnos/{id}/edit")
    public String editAlumno(@PathVariable Long id, Model model) {
        Recurso alumno = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("alumno", alumno);
        return "alumnos-formulario";
    }

    @PostMapping("/alumnos/{id}")
    public String updateAlumno(@PathVariable Long id, @ModelAttribute Recurso alumno) {
        alumno.setId(id);
        repo.save(alumno);
        return "redirect:/recursos/alumnos";
    }

    @PostMapping("/alumnos/{id}/delete")
    public String deleteAlumno(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/recursos/alumnos";
    }
}