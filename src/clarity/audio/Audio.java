package clarity.audio;

import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
  private Clip clip;
  private FloatControl gainControl;
  private BooleanControl muteControl;
  private static final int MICRO_SECONDS = 1000000;
  /**
   * Sound effects for every entity in the game.
   */
  public static HashMap<String, Audio> soundEffects = new HashMap<String, Audio>();
  /**
   * Music for the game.
   */
  public static HashMap<String, Audio> music = new HashMap<String, Audio>();

  /**
   * @param path Path to the audio file.
   */
  public Audio(String path) {
    try {
      // raw input
      AudioInputStream rawAudioInput =
          AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
      AudioFormat rawFormat = rawAudioInput.getFormat();
      // decoded input
      AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
          rawFormat.getSampleRate(), 16, rawFormat.getChannels(), rawFormat.getChannels() * 2,
          rawFormat.getSampleRate(), false);
      AudioInputStream decodedAudioInput =
          AudioSystem.getAudioInputStream(decodedFormat, rawAudioInput);
      // clip
      clip = AudioSystem.getClip();
      clip.open(decodedAudioInput);
      // volume and mute control
      gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
      muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public static void loadSoundEffects() {
    // soundEffects.put("name", new Audio("/sounds/soundEffects/pew.mp3"));
  }

  /**
   * Pause the music.
   */
  public static void pauseSongs() {
    for (String string : music.keySet()) {
      music.get(string).stop();
    }
  }

  /**
   * Resume the music.
   */
  public static void resumeSongs() {
    for (String string : music.keySet()) {
      music.get(string).resume();
    }
  }

  /**
   * @param amount Adjusts the gain by the percentage amount.
   */
  public void setGain(float amount) {
    float mult;

    if (amount > 100) {
      mult = 100;
    } else if (amount < 0) {
      mult = 0;
    } else {
      mult = amount;
    }

    float interval = Math.abs(gainControl.getMaximum() - gainControl.getMinimum()) / 100;
    gainControl.setValue(gainControl.getMinimum() + mult * interval);
  }

  public float getVolume() {
    return gainControl.getValue();
  }


  public void setMute(boolean mute) {
    muteControl.setValue(mute);
  }

  /**
   * Resume the music.
   */
  public void resume() {
    if (clip != null) {
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
  }

  /**
   * Play the music.
   */
  public void play() {
    if (clip != null) {
      stop();
      clip.setFramePosition(0);
      clip.start();
    }
  }

  /**
   * @param seconds The time in seconds to start the sound at.
   */
  public void playAt(double seconds) {
    if (clip != null) {
      stop();
      clip.setFramePosition(0);
      clip.setMicrosecondPosition((int) (seconds * MICRO_SECONDS));
      clip.start();
    }
  }

  /**
   * Stop the music.
   */
  public void stop() {
    if (clip != null) {
      if (clip.isRunning()) {
        clip.stop();
      }
    }
  }

  /**
   * Loop the music.
   */
  public void loop() {
    if (clip != null) {
      stop();
      clip.setFramePosition(0);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
  }

  /**
   * Close the music file.
   */
  public void close() {
    if (clip != null) {
      stop();
      clip.close();
    }
  }
}
