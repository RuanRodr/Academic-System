package br.ifce.academics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifce.academics.repository.*;
import br.ifce.academics.model.*;
import br.ifce.academics.service.MatriculaService;
import java.util.Optional;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
    private final MatriculaRepository repo;
    private final AlunoRepository alunoRepo;
    private final DisciplinaRepository discRepo;
    private final MatriculaService service;

    public MatriculaController(MatriculaRepository repo, AlunoRepository alunoRepo, DisciplinaRepository discRepo, MatriculaService service){
        this.repo = repo; this.alunoRepo = alunoRepo; this.discRepo = discRepo; this.service = service;
    }

    @GetMapping
    public String list(Model m){
        m.addAttribute("matriculas", repo.findAll());
        return "matriculas/list";
    }

    @GetMapping("/novo")
    public String novo(Model m){
        m.addAttribute("matricula", new Matricula());
        m.addAttribute("alunos", alunoRepo.findAll());
        m.addAttribute("disciplinas", discRepo.findAll());
        return "matriculas/form";
    }

    @PostMapping("/save")
    public String save(Matricula matricula, Model model){
        try{
            // load full aluno/disciplina
            if(matricula.getAluno()!=null && matricula.getAluno().getId()!=null){
                matricula.setAluno(alunoRepo.findById(matricula.getAluno().getId()).orElse(null));
            }
            if(matricula.getDisciplina()!=null && matricula.getDisciplina().getId()!=null){
                matricula.setDisciplina(discRepo.findById(matricula.getDisciplina().getId()).orElse(null));
            }
            service.save(matricula);
        }catch(Exception e){
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("matricula", matricula);
            model.addAttribute("alunos", alunoRepo.findAll());
            model.addAttribute("disciplinas", discRepo.findAll());
            return "matriculas/form";
        }
        return "redirect:/matriculas";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){ service.delete(id); return "redirect:/matriculas"; }
}
