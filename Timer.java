import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;
import java.io.File;


public class Timer {

    public static void main(String args[]){

    System.out.println("Hej! Den här räknar ner tiden. \nSkriv hur lång tid(sekunder): ");
    Scanner scan = new Scanner(System.in);        
    int i = scan.nextInt();
    
    try{
    while(i>0){
        TimeUnit.SECONDS.sleep(1);
        System.out.println(--i);
        if(i==0){
            playSound();
            System.out.println("Tiden är uuuuude");
            TimeUnit.SECONDS.sleep(1);
            //Spelar standardljudet på datorn.
            //Toolkit.getDefaultToolkit().beep();
        }
        }
    }catch(InterruptedException e){
    System.out.println("Error");
}
scan.close();
  
}

public static void playSound(){

    try{
    String ljud = "shall_we.wav";
    AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(ljud));
    Clip clip = AudioSystem.getClip();
    clip.open(audioIn);
    clip.start();
    }catch(UnsupportedAudioFileException|LineUnavailableException|IOException e){
        e.printStackTrace();
    }
}
}