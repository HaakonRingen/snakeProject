package SnakeProject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class HighScoreManager {


  public void writeToFile(String message) {  
    try {
      FileWriter myWriter = new FileWriter("highScores.txt");
      myWriter.write(message);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public int readFromFile() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("highScores.txt"));
        String line = reader.readLine();
        if (line != null) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                return Integer.parseInt(parts[1].trim());
            }
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    return 0; // Return 0 if high score couldn't be read
}

    
}

