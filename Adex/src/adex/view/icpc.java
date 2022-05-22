/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.view;

import java.util.Scanner;

/**
 *
 * @author Vega Laptop
 */
public class icpc {
    public static void main(String[] args) {
        String s1, s2;
        int num1, num2;
        Scanner input = new Scanner(System.in);
        s1 = input.next();
        s2 = input.next();
        for(int i = 0; i < s1.length();i++){
            num1 = (int)s1.charAt(i);
            num2 = (int)s2.charAt(i);
            if(num1 < 97){
                num1 += 32;
            }
            if(num2 < 97){
                num2 += 32;
            }
            if(num1 > num2){
                System.out.println(1);
                break;
            }else if(num2 > num1){
                System.out.println(-1);
                break;
            }else {
                if(i == s1.length()-1){
                    System.out.println(0);
                }else{
                    continue;
                }    
            }
        }
    }
}
