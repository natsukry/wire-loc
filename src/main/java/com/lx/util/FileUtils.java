package com.lx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Description:
 * Author:Jason Li
 * Date:2022-09-11
 * Time:9:34 PM
 */
public class FileUtils {
    public static String readAsString(File file) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (IOException e) {
        }
        return stringBuilder.toString();
    }
}
