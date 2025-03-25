package it.volta.ts.kamaninandrii.dockerfilegen.service;

import it.volta.ts.kamaninandrii.dockerfilegen.model.ProjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
public class ProjectAnalyzerService {

    private final Map<String, ProjectType> fileToProjectTypeMap;

    @Autowired
    public ProjectAnalyzerService(Map<String, ProjectType> projectFileMappings) {
        this.fileToProjectTypeMap = projectFileMappings;
    }

    public ProjectType analyzeProject(String projectPath) {
        Path path = Path.of(projectPath);

        System.out.println("Анализируем проект по пути: " + path);

        // Проверка наличия файлов с использованием маппинга
        for (Map.Entry<String, ProjectType> entry : fileToProjectTypeMap.entrySet()) {
            if (Files.exists(path.resolve(entry.getKey()))) {
                System.out.println("Найден " + entry.getKey() + " → " + entry.getValue());
                return entry.getValue();
            }
        }

        System.out.println("Файлы не найдены → UNKNOWN");
        return ProjectType.UNKNOWN;
    }
}