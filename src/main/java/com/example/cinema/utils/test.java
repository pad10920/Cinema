/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.utils;


import com.example.cinema.dao.PhimDAO;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cuong
 */


public class test {
    
    private static final String imageLink = "E:\\D19 - Nam 3 Ky 2\\D19-LTWeb\\Image\\";
    private static final String imageLinkSave = "E:\\D19 - Nam 3 Ky 2\\D19-LTWeb\\NVC\\Cinema\\web\\view\\img\\";
    PhimDAO phimDAO = new PhimDAO();
   
    public static void save(String filename, String res){
        File file1 = new File(imageLink + filename);
        File file2 = new File(imageLinkSave + "anh.jpg");
        File file3 = new File(imageLinkSave + res);
        try {
            Files.copy(file1.toPath(), file2.toPath());
            file2.renameTo(file3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
