package br.ifce.academics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifce.academics.service.AlunoService;
import br.ifce.academics.model.Aluno;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;
    public AlunoController(AlunoService service){ this.service = service; }

    @GetMapping
    public String list(Model m){
        m.addAttribute("alunos", service.findAll());
        return "alunos/list";
    }

    @GetMapping("/novo")
    public String novo(Model m){
        m.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }

    @PostMapping("/save")
    public String save(Aluno aluno, Model model){
        try{
            service.save(aluno);
        }catch(Exception e){
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("aluno", aluno);
            return "alunos/form";
        }
        return "redirect:/alunos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model m){
        Optional<Aluno> a = service.findById(id);
        if(a.isPresent()){ m.addAttribute("aluno", a.get()); return "alunos/form"; }
        return "redirect:/alunos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){ service.delete(id); return "redirect:/alunos"; }
}
