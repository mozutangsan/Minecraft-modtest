package com.example.examplemod;

import java.util.Arrays;

public class Zhishu {
    public static boolean zs(int[] zsz, int pds){
        for(int zsl:zsz){
            if (pds/3<zsl){
                break;
            }
            if(pds%zsl==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] a={2};
        for(int b=3;b<=100;b++){
            if(Zhishu.zs(a,b)==true){
                int[] ab= Arrays.copyOf(a,a.length+1);
                ab[a.length]=b;
                a=Arrays.copyOf(ab,ab.length);
            }
        }
        for(int c:a){
            System.out.println(c);
        }
    }
}
