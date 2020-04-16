package FastPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FastestPath {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Find the Path.");
        File dataFile = new File("./DataFile/data1.dat");
        Scanner dataRead = new Scanner(dataFile);

        while(dataRead.hasNext()){
            System.out.println(dataRead.nextLine());
        }

    }
}