package it.volta.ts.kamaninandrii.dockerfilegen.controller;


import it.volta.ts.kamaninandrii.dockerfilegen.model.ProjectType;
import it.volta.ts.kamaninandrii.dockerfilegen.service.ProjectAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DockerfileController {

    private final ProjectAnalyzerService projectAnalyzerService;

    @GetMapping("/project/scan")
    public ProjectType scanProject(@RequestParam String path) {
        System.out.println("Проверяем путь: " + path);


        return projectAnalyzerService.analyzeProject(path);
    }
}