package com.bova.services.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by m.bova on 18.07.2016.
 */
public class FileUtil {

    public static final String JSON_ROOT = "src/main/resources/";

    public static String readJsonFile(String... resourceNames) {
        final String resourceName = buildResourceName(resourceNames);

        try {
            final File resource = getFile(resourceName);
            if (resource.isFile()) {
                return FileUtils.readFileToString(resource);
            }
            throw new RuntimeException("resourceName " + resourceName + " isn't a file");
        } catch (IOException e) {
            throw new RuntimeException("Unable to open the resource " + resourceName, e);
        }
    }

    public  static byte[] getRawFile(String fileName) {
        try {
            return FileUtils.readFileToByteArray(getFile(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read the file " + fileName, e);
        }
    }

    private static File getFile(String pathname) {
        return new File(JSON_ROOT + pathname);
    }

    private  static String buildResourceName(String[] resourceNames) {
        final StringBuilder sb = new StringBuilder();
        for (final String resourceName : resourceNames) {
            sb.append("/").append(resourceName);
        }
        return sb.substring(1);
    }
}
