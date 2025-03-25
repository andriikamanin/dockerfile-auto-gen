package it.volta.ts.kamaninandrii.dockerfilegen.config;

import it.volta.ts.kamaninandrii.dockerfilegen.model.ProjectType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ProjectTypeConfig {

    @Bean
    public Map<String, ProjectType> projectFileMappings() {
        // Сопоставляем имена файлов с типом проекта
        return Map.of(
                "requirements.txt", ProjectType.PYTHON,
                "package.json", ProjectType.NODEJS,
                "go.mod", ProjectType.GO,
                "pom.xml", ProjectType.JAVA,
                "build.gradle", ProjectType.JAVA,
                "settings.gradle", ProjectType.JAVA
        );
    }
}