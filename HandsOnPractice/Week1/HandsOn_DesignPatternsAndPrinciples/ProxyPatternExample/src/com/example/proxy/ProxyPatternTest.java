package com.example.proxy;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");

        // Image will be loaded from remote server (lazy)
        image1.display();
        System.out.println("---");

        // This time, it will be retrieved from cache
        image1.display();
        System.out.println("---");

        // Another image
        Image image2 = new ProxyImage("photo2.jpg");
        image2.display();
    }
}
