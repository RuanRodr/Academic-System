package br.ifce.academics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifce.academics.repository.DisciplinaRepository;
import br.ifce.academics.model.Disciplina;
import java.util.Optional;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaRepository repo;
    public DisciplinaController(DisciplinaRepository repo){ this.repo = repo; }

    @GetMapping
    public String list(Model m){
        m.addAttribute("disciplinas", repo.findAll());
        return "disciplinas/list";
    }

    @GetMapping("/novo")
    public String novo(Model m){
        m.addAttribute("disciplina", new Disciplina());
        return "disciplinas/form";
    }

    @PostMapping("/save")
    public String save(Disciplina d, Model model){
        if(d.getCodigo()==null || d.getCodigo().isBlank()){
            model.addAttribute("erro", "Código obrigatório");
            model.addAttribute("disciplina", d);
            return "disciplinas/form";
        }
        try{ repo.save(d); } catch(Exception e){ model.addAttribute("erro", e.getMessage()); model.addAttribute("disciplina", d); return "disciplinas/form"; }
        return "redirect:/disciplinas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model m){
        Optional<Disciplina> d = repo.findById(id);
        if(d.isPresent()){ m.addAttribute("disciplina", d.get()); return "disciplinas/form"; }
        return "redirect:/disciplinas";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){ repo.deleteById(id); return "redirect:/disciplinas"; }
}
