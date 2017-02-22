package clarity.main;

import clarity.audio.Audio;

public class Main {

  public static void main(String[] args) {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setGain(50);
    audio.loop();
    try {
      Thread.sleep(5000);                 //1000 milliseconds is one second.
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    //new Game();
  }

}
