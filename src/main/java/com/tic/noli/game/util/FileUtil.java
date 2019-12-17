package com.tic.noli.game.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public static String readStringFromFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(FileUtil.class.getResource(path).toURI())));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
