package com.lkg.demo.share;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParseImpl {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\lkg\\Desktop\\统一安全展示平台-定制开发工时进度估算.xlsx";
        System.out.println(ExcelUtils.getSheetNames(path));
    }
    
    public void parseTxt() throws IOException {
        String path = "C:\\Code\\lkgGithub\\study-java\\src\\main\\java\\com\\lkg\\study\\share\\aa.txt";

        File file = new File(path);
        BufferedReader buf = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        while((line=buf.readLine())!=null){
            content.append(line).append(System.getProperty("line.separator"));
        }
        buf.close();

        System.out.println(content.toString());
    }

}
