/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetusers.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Merxv
 */
public class InternetUsersJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String country[] = null;
        int userpercent[];
        System.out.println("input filename of string ");
        Scanner n  = new Scanner(System.in);
        String fname = n.nextLine();
        
        String str="";
        Scanner s = null;
        
        try{
            s = new Scanner(new BufferedReader(new FileReader(fname)));
            while(s.hasNext()){
                str = str + " " + s.nextLine() + "\n";
             
            }
        }
        finally{
            if(s != null)
                s.close();
        }
        
        System.out.println(str);
    }
}
