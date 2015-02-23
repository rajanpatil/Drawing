package com.drawing;

import java.util.Arrays;

/**
 * Created by ee on 23/2/15.
 */
public class Test {

    public static void main(String args[]){
        char[][] a =new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'|', 'x', 'x', 'x', ' ', '|'},
                {'|', 'x', 'o', 'x', ' ', '|'},
                {'|', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-'},
        };

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]);
            }
            System.out.print('n');
        }
    }
}
