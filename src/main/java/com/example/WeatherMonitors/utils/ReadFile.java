package com.example.WeatherMonitors.utils;

import com.example.WeatherMonitors.model.CityConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;;
import java.util.List;

public class ReadFile {

    static List<CityConfig> configurationList;

    public static List<CityConfig>  getJson(String path) {
        File file = null;

        try {
            file = ResourceUtils.getFile(path);

            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();

             configurationList = mapper.readValue(content, new TypeReference<>(){});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configurationList ;
    }

}
