package com.example.WeatherMonitors.utils;

import com.example.WeatherMonitors.model.CityConfiguration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.File;
import java.nio.file.Files;;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil {

    public static List<CityConfiguration> getConfigsFromJson(String jsonFile) {
        File file;

        try {
            Resource resource = new ClassPathResource(jsonFile);
            file = resource.getFile();

            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content, new TypeReference<>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
