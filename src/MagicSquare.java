//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MagicSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Boolean magic = true;
        int T = Integer.parseInt(reader.readLine());
        int[][] square = new int[T][T];
        for (int i = 0; i < T; i++) {
            int j = 0;
            String[] str = reader.readLine().split(" ");
            for (String s : str) {
//                System.out.println(i + "  "+ j + "   " +s );
                square[i][j] = Integer.parseInt(s);

                j++;
            }
        }
        int maindiagonal = 0;
        Stack<Integer> diff = new Stack();
        if (magic == true) {
            for (int i = 0; i < T; i++) {
                maindiagonal += square[i][i];
            }
        }

        int total = 0;
        int k=0;
        boolean antidia = true;
        for (int i = T - 1; i >= 0; i--) {
            total += square[k][i];
            k++;
        }
        if (maindiagonal!= total) {
            magic = false;
            antidia = false;
        }
//        System.out.println( total);










        int[] ver = new int[T];
        for (int i = 0; i < T; i++) {
            total = 0;
            for (int j = 0; j < T; j++) {
                total += square[j][i];
            }
            ver[i] = total;
        }

        for (int i = T-1; i >=0; i--) {
            System.out.println(i + "  " + ver.length);
            if (ver[i] != maindiagonal) {
                magic = false;
                diff.push((i+1)*-1);
            }
        }

        int[] hori = new int[T];
        for (int i = 0; i < T; i++) {
            total = 0;
            for (int j = 0; j < T; j++) {
                total = total + square[i][j];
            }
            hori[i] = total;

        }
//        System.out.println(Arrays.toString(hori));
        for (int i = T-1; i >=0; i--) {
            if (hori[i] !=maindiagonal){
                magic = false;
                diff.push((i+1));
            }

        }


        if (magic==true) {
            System.out.println(0);
        }
        else{
            if(!antidia) {
                System.out.println(diff.size() +1);
            }
            else{
                System.out.println(diff.size());
            }


            Collections.sort(diff,Collections.reverseOrder());
            while(!diff.isEmpty()){
                System.out.println(diff.pop());

            }
            if(!antidia){
                System.out.println(0);
            }
        }
    }
}



