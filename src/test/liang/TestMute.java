package test.liang;

import static org.junit.Assert.assertEquals;

import clarity.audio.Audio;

import org.junit.Test;

public class TestMute {

  @Test
  public void testMute() {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setMute(true);
    float curVolume = audio.getVolume();
    assertEquals((float) 0, curVolume, 0);
  }

}
