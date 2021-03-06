package services;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface FileReaderService {

    List<String> readRows(String filePath);

    boolean isCorrectPath(String filePathString);

}
