import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkMe2 {

    node front;
    node temp;

    void init(){
        front = null;
    }

    node makeNode(int num, String name){
        node newNode = new node();
        newNode.data = num;
        newNode.name = name;
        newNode.next = null;
        return newNode;
    }

    node findTail(){
        node current = front;
        while(current.next != null){
            current = current.next;
        }
        return current;
    }

    void showList(){
        node c = front;
        while(c != null){
            System.out.println(c.name);
            c = c.next;
        }
    }

    node insert(int num, String name){

        node prev, curr;
        node temp = makeNode(num, name);
        boolean searching;

        if(num < front.data){
            temp = makeNode(num, name);
            temp.next = front;
            front = temp;
        }
        else if(front == null){
            temp = makeNode(num, name);
            temp = front;
            temp.next = null;

        }
        else{
            curr = front;
            prev = curr;
            searching = true;
            while(searching){
                if(curr.data == num){
                    System.out.println("Duplicate name. Inserting after original...");
                    temp = makeNode(num, name);
                    curr.next = temp;
                    temp.next = curr.next;
                    searching = false;
                }
                else if(curr.data < num){
                    if(curr.next == null){
                        curr.next = makeNode(num, name);
                        searching = false;
                    }
                    else{
                        prev = curr;
                        curr = curr.next;
                    }
                }
                else if(curr.data > num){
                    temp = makeNode(num, name);
                    temp.next = curr;
                    prev.next = temp;
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
