import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class jukebox {
    private static Clip clip;

    public static void playSong(String filePath) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop(); // Stop any currently playing song
            }

            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("Playing: " + filePath);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing the song: " + e.getMessage());
        }
    }

    public static void showJukeboxMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n *** Music player menu *** ");
            System.out.println("1. Play 'Song 1'");
            System.out.println("2. Play 'Song 2'");
            System.out.println("3. Play 'Song 3'");
            System.out.println("4. Play 'Song 4'");
            System.out.println("4. Stop Music");
            System.out.println("5. Exit Jukebox");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> playSong("song1.wav");    // Make sure to have song1.wav in the project folder
                case 2 -> playSong("song2.wav");    // And ensure the audio file exists
                case 3 -> playSong("song3.wav");
                case 4 -> playSong("song4.wav");
                case 5 -> {
                    if (clip != null && clip.isRunning()) {
                        clip.stop();
                        System.out.println("Music stopped.");
                    } else {
                        System.out.println("No music is playing.");
                    }
                }
                case 6 -> {
                    clip.stop();
                    System.out.println("Exiting Jukebox...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
