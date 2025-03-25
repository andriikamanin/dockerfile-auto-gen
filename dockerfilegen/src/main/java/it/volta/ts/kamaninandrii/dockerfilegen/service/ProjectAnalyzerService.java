package it.volta.ts.kamaninandrii.dockerfilegen.service;

import it.volta.ts.kamaninandrii.dockerfilegen.model.ProjectType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ProjectAnalyzerService {

    public ProjectType analyzeProject(String projectPath) {
        Path path = Paths.get(new File(projectPath).getAbsolutePath());

        System.out.println("Анализируем проект по пути: " + path);

        if (Files.exists(path.resolve("requirements.txt"))) {
            System.out.println("Найден requirements.txt → Python");
            return ProjectType.PYTHON;
        } else if (Files.exists(path.resolve("package.json"))) {
            System.out.println("Найден package.json → Node.js");
            return ProjectType.NODEJS;
        } else if (Files.exists(path.resolve("go.mod"))) {
            System.out.println("Найден go.mod → Go");
            return ProjectType.GO;
        } else if (Files.exists(path.resolve("pom.xml")) || Files.exists(path.resolve("build.gradle")) || Files.exists(path.resolve("settings.gradle"))) {
            System.out.println("Найден  → Java");
            return ProjectType.JAVA;
        }

        System.out.println("Файлы не найдены → UNKNOWN");
        return ProjectType.UNKNOWN;
    }
}