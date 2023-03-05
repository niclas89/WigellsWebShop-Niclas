package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestThread extends Thread{
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    TshirtInterFaceTest interFace ;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    public void run(){
        for(int i = 0; i<1000; i++){
            provideInput("1");
            try{
                Thread.sleep(0,5000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }




        }

    }



    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
