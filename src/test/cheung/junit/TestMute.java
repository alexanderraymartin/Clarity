package test.cheung.junit;

// Liang Cheung

import static org.junit.Assert.assertTrue;

import clarity.audio.Audio;

import org.junit.Test;

public class TestMute {

  @Test
  public void testMute() {
    Audio audio = new Audio("/sounds/soundEffects/bizarre-guitar-daniel_simon.mp3");
    audio.setMute(true);
    assertTrue(audio.isMuted());
  }

}
