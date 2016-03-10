/*
This program gives the user 4 options, creating, editing, reading, and deleting
a text file. 
*/

package file.handling.program;

import java.io.*;
import java.util.Scanner;

/** 
 *
 *
 *
 */
public class FileHandlingProgram {
        
    //variables used in the program
    static Scanner sc = new Scanner(System.in);
    static int choice;
    static String lineOfText;
    static FileReader in;
    static FileWriter out;
    static BufferedReader readFile;
    static BufferedWriter writeFile;
    static File dataFile = new File("textFile.txt");
    static File textFile = new File("textFile.txt");
    
    public static void editFile() {
        try {
            out = new FileWriter(dataFile); //creating an output stream to the file
            writeFile = new BufferedWriter(out);
            boolean t = true; //used for the while loop
            System.out.println("Please enter what you would like to add to the file. Type escape to finish writing.");
            while (t) {
                lineOfText = sc.nextLine();
                if (lineOfText.equals("escape")) {
                    //runs if the user types escape to leave the editor
                    t = false;
                }
                else {
                    //writes to the file and adds a new line
                    writeFile.write(lineOfText);
                    writeFile.newLine(); 
                }
            }
            //closing the file and output stream
            writeFile.close(); 
            out.close();
            System.out.println("Writing added to file.");
        }
        catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Could Not Read The File");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    
    public static void readFile() {
         try {
            in = new FileReader(textFile); //creating an input stream to the file
            readFile = new BufferedReader(in);
            while ((lineOfText = readFile.readLine()) != null) {
                //runs as long as there is text
                System.out.println(lineOfText);
            }
            //closing the file and input stream
            readFile.close();
            in.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Could not read the file");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {

        
        while (true) {
            //Menu options
            System.out.println("What would you like to do?\n"
                    + "1. Create a text file\n"
                    + "2. Edit the text file\n"
                    + "3. Delete the text file\n"
                    + "4. Read the text file\n"
                    + "5. Exit\n");
            choice = sc.nextInt();
            switch (choice) {
                case 1: //Creating the text file
                    try {
                        textFile.createNewFile(); //Creating a new file
                        System.out.println("File created."); 
                    }
                    catch (IOException e) { //Catching an IOException error
                        System.out.println("File could not be created.");
                        System.err.println("IOException: " + e.getMessage());
                    }
                    break;
                case 2: //Editing the text file
                    editFile();
                    break;
                case 3: //Deleting the text file
                        if (textFile.delete()) { /*This tries to delete the file
                                                 and returns a value of 1 or 0
                                                 depending on whether it is
                                                 successful or not*/
                            System.out.println("The file was deleted.");
                            //This runs if the file was successfully deleted
                        }
                        else {
                            System.out.println("There is no file to delete.");
                            //This runs if the file was not deleted
                        }
                    break;
                case 4: //Reading the text file
                    readFile();
                    break;
                case 6: //Exiting the program
                    System.exit(0);
                    break;
            }
        }    
    }
    
}
