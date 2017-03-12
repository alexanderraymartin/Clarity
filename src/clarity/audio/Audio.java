package clarity.audio;

import clarity.utilities.GameLogger;

import java.util.HashMap;
import java.util.Map;

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
  private static final Map<String, Audio> soundEffects = new HashMap<>();
  private static final Map<String, Audio> music = new HashMap<>();

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

      // TODO Remove set gain and add volume control
      setGain(70);

    } catch (Exception exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
  }

  // TODO: Implement this method
  public static void loadSoundEffects() {
    // soundEffects.put("name", new Audio("/sounds/soundEffects/pew.mp3"));
  }

  /**
   * Pause the music.
   */
  public static void pauseSongs() {
    getMusic().forEach((name, song) -> song.stop());
  }

  /**
   * Resume the music.
   */
  public static void resumeSongs() {
    getMusic().forEach((name, song) -> song.resume());
  }

  /**
   * Sound effects for every entity in the game.
   */
  public static Map<String, Audio> getSoundEffects() {
    return soundEffects;
  }

  /**
   * Music for the game.
   */
  public static Map<String, Audio> getMusic() {
    return music;
  }

  /**
   * @param amount Adjusts the gain by the percentage amount.
   */
  public void setGain(float amount) {
    if (amount > 100) {
      gainControl.setValue(gainControl.getMaximum());
    } else if (amount < 0) {
      gainControl.setValue(gainControl.getMinimum());
    } else {
      float interval = Math.abs(gainControl.getMaximum() - gainControl.getMinimum()) / 100;
      gainControl.setValue(gainControl.getMinimum() + amount * interval);
    }
  }

  public float getMaximum() {
    return gainControl.getMaximum();
  }

  public float getMinimum() {
    return gainControl.getMinimum();
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
    if (clip != null && clip.isRunning()) {
      clip.stop();
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
