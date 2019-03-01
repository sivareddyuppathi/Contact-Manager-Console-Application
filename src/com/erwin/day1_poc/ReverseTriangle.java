package com.erwin.day1_poc;

import java.util.Scanner;

public class ReverseTriangle {
    public static void main(String[] args) {
        
        Scanner s= new Scanner(System.in);
        
        System.out.print("Enter size of the reverse triangle : ");
        
        int noOfRows=s.nextInt();
        
        for(int i=1;i<=noOfRows;i++){
            
            for(int j=noOfRows;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
