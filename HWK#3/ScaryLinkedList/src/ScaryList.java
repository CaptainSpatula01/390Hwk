import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 



public class ScaryList {
    public static void main(String [] args) {
        try{

            System.out.println("Enter file name ");

            Scanner userInput = new Scanner(System.in);
            String fileName;
            fileName = userInput.nextLine();
            userInput.close();
            //System.out.println(fileName);

            File userFile = new File(fileName);
            Scanner fileRead = new Scanner(userFile);

            while (fileRead.hasNextLine()) {
               String data = fileRead.nextLine();
               System.out.println(data);
            }
            fileRead.close();
        }      
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
