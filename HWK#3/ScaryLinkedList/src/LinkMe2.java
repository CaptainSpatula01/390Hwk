import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkMe2 {

    Node front;
    Node temp;

    void init(){
        front = null;
    }

    Node makeNode(int num, String name){
        return new Node(num, name);
    }

    Node findTail(){
        Node current = front;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current;
    }

    void showList(){
        Node c = front;
        while(c != null){
            System.out.println(c.getName());
            c = c.getNext();
        }
    }

    Node insert(int num, String name){

        Node prev, curr;
        Node temp = makeNode(num, name);
        boolean searching;

        if(num < front.getData()){
            temp = makeNode(num, name);
            temp.setNext(front);
            front = temp;
        }
        else if(front == null){
            temp = makeNode(num, name);
            temp = front;
            temp.setNext(null);
        }
        else{
            curr = front;
            prev = curr;
            searching = true;
            while(searching){
                if(curr.getData() == num){
                    System.out.println("Duplicate name. Inserting after original...");
                    temp = makeNode(num, name);
                    curr.setNext(temp);
                    temp.setNext(curr.getNext());
                    searching = false;
                }
                else if(curr.getData() < num){
                    if(curr.getNext() == null){
                        curr.setNext(makeNode(num, name));
                        searching = false;
                    }
                    else{
                        prev = curr;
                        curr = curr.getNext();
                    }
                }
                else if(curr.getData() > num){
                    temp = makeNode(num, name);
                    temp.setNext(curr);
                    prev.setNext(temp);
                    searching = false;
                }
            }
        }
        return temp;
    }

    void buildScaryList(){
        //Build the list in alphabet order
        try{

            System.out.println("Enter file name ");

            Scanner userInput = new Scanner(System.in);
            String fileName;
            fileName = userInput.nextLine();
            userInput.close();
            

            File userFile = new File(fileName);
            Scanner fileRead = new Scanner(userFile);

            while (fileRead.hasNextLine()) {
               String data = fileRead.nextLine();
               int wordValue = ((data.charAt(0) - 'a') * (int) Math.pow(26, 2)) 
               + ((data.charAt(1) - 'a') * (int) Math.pow(26, 1)) 
               + ((data.charAt(2) - 'a') * (int) Math.pow(26, 0));
                            

               //System.out.println(data + " " + wordValue);
               temp = makeNode(wordValue, data);
               System.out.println(temp);

            }

            fileRead.close();
        }      
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
