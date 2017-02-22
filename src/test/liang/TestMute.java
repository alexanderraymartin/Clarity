package test.liang;

import static org.junit.Assert.*;

import org.junit.Test;

import clarity.audio.Audio;

public class TestMute {

  @Test
  public void testMute() {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setMute(true);
    float curVolume = audio.getVolume();
    assertEquals((float)0, curVolume, 0);
  }

}
