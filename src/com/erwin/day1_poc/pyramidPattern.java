package com.erwin.day1_poc;
import java.util.Scanner;

public class pyramidPattern {

    public static void main(String[] args) {
        
        System.out.print("Enter the pyramid size : ");
        Scanner sc= new Scanner(System.in);
        
        int size=sc.nextInt();
       
        for(int rows=size;rows>=1;rows--){
            
            for(int j=1;j<=(2*size-rows);j++){
                if(j<rows){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }               
            }
             System.out.println();
        }
    }    
}
