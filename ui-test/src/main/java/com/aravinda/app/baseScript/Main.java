package com.aravinda.app.baseScript;

public class Main {
    public static void main(String[] args) {
        XLReader xl = new XLReader();
        for (String a : xl.getData(2)) {
            System.out.println(a);
        }
    }
}
