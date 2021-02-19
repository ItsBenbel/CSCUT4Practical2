import java.io.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
// Import the Scanner class
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) throws FileNotFoundException {
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.
    	File input;
    	File output;
    	boolean uppercase;
    	if (args[2].equals("-u")) {
    		 input = new File(args[3]);
        	 output = new File(args[4]);
        	 uppercase = true;
    	}else{
    	 input = new File(args[2]);
    	 output = new File(args[3]);
    	 uppercase = false;
    	//System.out.println(output.isFile());
    	//System.out.println(input.isFile());  //testing the file location
    }
    	
    	Scanner scan = new Scanner(input);
    	
    	//Reading each line of file using Scanner class
    	LinkedList<String> inputFile = new LinkedList<String>();
        while(scan.hasNextLine()){
            inputFile.add(scan.nextLine());
            //System.out.println(inputFile.getLast()); //testing all the lines were fouund
        } 
        inputFile = modifyFile(inputFile, uppercase);
        
        for(int i = 0; i<inputFile.size(); i++) {
        	System.out.println(inputFile.get(i));
        }
        
        
        try {
            FileWriter myWriter = new FileWriter(output);
            for(int i = 0; i<inputFile.size(); i++) {
            	myWriter.write(inputFile.get(i)+"\n");
            }
            
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
        //now need to send this to the output text file//////////////////////////////////////////
    	

        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.

        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.
    	

        //System.out.println("You need to add your own code to do anything");

    } // main
    
    public static LinkedList<String> modifyFile(LinkedList<String> inputFile, boolean uppercase){
    	String stringHolder = "";
    	LinkedList<String> newString = new LinkedList<String>();
    	int lastSpace;
    	for(int i = 0; i<inputFile.size(); i++) {
    		//stringHolder = inputFile.get(i);
    		
    		if(uppercase) {
    			stringHolder = inputFile.get(i).toUpperCase();
    			lastSpace = stringHolder.lastIndexOf(" ")+1;
    			stringHolder = stringHolder.substring(0, lastSpace)+"      \t" +formatDate(stringHolder.substring(lastSpace));
    		}else {
    		stringHolder = capitalize(inputFile.get(i).substring(0,inputFile.get(i).indexOf(" ")+1)); //capitalize the first word
    		inputFile.set(i, inputFile.get(i).substring(inputFile.get(i).indexOf(" ")+1));	//removing the formatted word
    		
    		stringHolder = stringHolder + capitalize(inputFile.get(i).substring(0,inputFile.get(i).indexOf(" ")+1)); //capitalize the first word
    		inputFile.set(i, inputFile.get(i).substring(inputFile.get(i).indexOf(" ")+1));	//removing the formatted word
    		
    		stringHolder = stringHolder+"      \t"  + formatDate(inputFile.get(i)); //formatting the date
    		}
    		//System.out.println(stringHolder);
    		newString.add(stringHolder);
    		
    	}
    	
    	return newString;
    }
    
    public static String capitalize(String name) { //method to capitalize a word
    	name = name.substring(0,1).toUpperCase() + name.substring(1);
    	return name;
    }
    
    public static String formatDate(String date) { //method to format the date
    	date = date.substring(0,2)+"/"+date.substring(2,4)+"/"+date.substring(4,8);
    	return date;
    }
} // FilesInOut
