package services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.FileReaderService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * @author Roman Nagibov
 */
public class DefaultFileReaderService implements FileReaderService {

    private static final Logger LOGGER = LogManager.getLogger(DefaultFileReaderService.class);
    private static FileReaderService fileReaderService;


    public static FileReaderService getInstance() {
        if (null == fileReaderService) {
            fileReaderService = new DefaultFileReaderService();
        }
        return fileReaderService;
    }

    @Override
    public List<String> readRows(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isCorrectPath(String filePath)  {
        File file = new File(filePath);
        return (file.exists() && !file.isDirectory());
    }

}
