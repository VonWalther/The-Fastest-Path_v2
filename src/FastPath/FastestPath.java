package FastPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FastestPath {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Find the Path.");
        File dataFile = new File("./DataFiles/data1.dat");
        if(!dataFile.exists()){
            System.out.println("The file does not exist.");
            System.exit(1);
        }
        Scanner dataRead = new Scanner(dataFile);
        //Read in number of Paths , first line in the data file.
        int numOfPaths = dataRead.nextInt();
        dataRead.nextLine(); //Moves to the next line.
        //Set up variables
        double shortestPathLength = 40000.0;
        //Read in a line and find the path length.
        while(dataRead.hasNextLine()){
            String fullLine = dataRead.nextLine();
            //Take the first letter and turn it into an interger.
            int numOfPoints = Character.getNumericValue(fullLine.charAt(0));
            double newPathLength = 0;  //Set the path length to zero.
            //Read the first point in the pair.
            int x = Character.getNumericValue(fullLine.charAt(1));
            int y = Character.getNumericValue(fullLine.charAt(2));
            for(int i = 3; i < numOfPoints * 2; i += 2 ){
                int xPrime = Character.getNumericValue(fullLine.charAt( i ));
                int yPrime = Character.getNumericValue(fullLine.charAt( i + 1 ));
                //Add the Path Length to the existing path length.
                newPathLength = newPathLength + findDistance(x, y, xPrime, yPrime);
                x = xPrime;
                y = yPrime;
                }
            //Check to see if the new file path is smaller then the last.
            if(newPathLength < shortestPathLength){
                shortestPathLength = newPathLength;
            }
            System.out.println(shortestPathLength);
            /*********
             * Just need to keep track of with path is the shortest and print out correct output.
             */
        }

    }

    public static double findDistance(int x1, int y1, int x2, int y2){
        double dist = Math.sqrt( Math.pow(x1-x2,2) + Math.pow(y1-y2,2) );
        return( dist );
    }

}