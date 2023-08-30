package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ImageProcessor.convertFileToWebp("tiger.jpeg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}