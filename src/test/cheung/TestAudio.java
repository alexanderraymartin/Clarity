package test.cheung;

// Liang Cheung

import static org.junit.Assert.assertEquals;

import clarity.audio.Audio;

import org.junit.Test;

public class TestAudio {

  @Test
  public void testVolumeControl() {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setGain(50);
    float curVolume = audio.getVolume();
    assertEquals((float) -36.9897, curVolume, 0);
  }

  @Test
  public void testExceedMax() {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setGain(200);
    float curVolume = audio.getVolume();
    assertEquals(audio.getMaximum(), curVolume, 0);
  }

  @Test
  public void testExceedMin() {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setGain(-10);
    float curVolume = audio.getVolume();
    assertEquals(audio.getMinimum(), curVolume, 0);
  }
}
