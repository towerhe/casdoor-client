package com.yicenyun.casdoor.client.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

    /**
     * Read the content of a file under class paths.
     *
     * @param path file path
     * @return content of file in string format
     * @throws IOException
     */
    public static String readResource(String path) throws IOException {
        InputStream inputStream = FileUtils.class.getResourceAsStream(path);
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }

        return resultStringBuilder.toString().trim();
    }
}
