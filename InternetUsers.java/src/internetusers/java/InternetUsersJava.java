/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetusers.java;

import java.io.*;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author Merxv
 */
public class InternetUsersJava {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String[] country = new String[201];
        int[] userpercent = new int[201];
        String[] hash = new String[250];
        int[] hashPercent = new int[250];
        int j;
        int inputSum = 0;
        File file = new File("/Users/max/assignment3/InternetUsers.java/src/internetusers/java/CountrySortedAlpha.txt");
        Scanner n = new Scanner(System.in);
        String str;
        Scanner s = null;

        //read in country
        try {
            s = new Scanner(file);

            //read in from document and show it's contents 
            while (s.hasNext()) {
                for (int i = 0; i < 201; i++) {
                    str = s.nextLine();
                    String str1 = str.substring(0,27).trim();
                    int str2= parseInt(str.substring(str.length() - 2).trim());
                    country[i] = str1;
                    userpercent[i] = str2;
                    System.out.print(country[i]);
                    System.out.print("\t" + userpercent[i] + "\n");
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        
        //shell sort
       for(int gap = userpercent.length/2; gap > 0; gap /= 2){
            System.out.println("\nBefore Gap: " + gap);
            for (int k=0;k<userpercent.length;k++){
                 System.out.print(userpercent[k]);
                 System.out.print(" ");
            }
             for( int i = gap; i < userpercent.length; i++ ){
                int tmp = userpercent[i]; 
                String tmp2 = country[i];
                for(j=i; j >= gap && (tmp < userpercent[j-gap]); j -= gap){
                    userpercent[j] = userpercent[j-gap];
                    country[j] = country[j-gap];
                }
                userpercent[j] = tmp;
                country[j] = tmp2;
             }
        }
       
       //hash
       for(int i = 0; i < 201; i++){
           int countrySum = 0;
           for(int g = 0; g < country[i].length(); g++){
               String lowerCase = country[i].toLowerCase();
               countrySum += (lowerCase.charAt(g) - 48);
           }
           int hashSum = (countrySum % 250);
           if(hash[hashSum] == null){
               hash[hashSum] = country[i];
               hashPercent[hashSum] = userpercent[i];
           }else{
               while(hash[hashSum] != null){
                   hashSum++;
               }
               hash[hashSum] = country[i];
               hashPercent[hashSum] = userpercent[i];
           }
       }
       
       //final sort
        System.out.println("\nFinal sorted order:");
        for(int k = 0; k < userpercent.length; k++){
            System.out.print(country[200 - k] + "\t");
            System.out.print(userpercent[200 - k] + "\t");
            System.out.print(hash[k] + "\n");
        }
        
        System.out.println("Enter a country, -1 to quit.");
        String input = n.nextLine().trim();
        
        //search
        while (!input.equals("-1")){
            
            for(int g = 0; g < input.length(); g++){
               inputSum += input.charAt(g) - 48;
               inputSum %= 250;
           }
            
            if(hash[inputSum].equalsIgnoreCase(input)){
                System.out.println(hash[inputSum] + " "  + hashPercent[inputSum]);
            }else{
                while(!hash[inputSum].equalsIgnoreCase(input)){
                    inputSum++;
                    if(hash[inputSum] == null){
                        System.out.println("Country not found!");
                        break;
                    }else{
                      System.out.println(hash[inputSum] + "\t" + hashPercent[inputSum] + "\n");
                    }
                }
            }
            
            System.out.println("Enter a country, -1 to quit.");
            input = n.nextLine().toLowerCase().trim();
        }
    }
}
