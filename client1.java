import java.io.*; 
import java.net.*;
import java.util.Random;
import java.util.Scanner; 
  
// Client class 
public class client1
{ 
    public static void main(String[] args) throws IOException  
    { 
        try
        { 
            Scanner scn = new Scanner(System.in); //Taking input from system
              
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 
      
            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5056); 
      
            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
      
            // the following loop performs the exchange of 
            // information between client and client handler 
            System.out.println(dis.readUTF()); 
            String name = scn.nextLine(); 
            dos.writeUTF(name); 
            String give_number;
            int number;
            while (true)  
            { 
               
                System.out.println(dis.readUTF()); 
                give_number = scn.nextLine(); 
                if(give_number.equals("yes")) //generating a random integer to pass it to server
                {
                	Random r = new Random();
                	number = r.nextInt(10)+5;
                	Integer int_number =  new Integer(number);
                	dos.writeUTF(int_number.toString()); 
                } 
                // If client sends exit,close this connection  
                // and then break from the while loop 
                if(give_number.equals("no"))  // if user gives "no" then we close the connection
                { 
                	
                    System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 
                  
                // printing date or time as requested by client 
                String received = dis.readUTF(); 
                System.out.println(received); 
            } 
              
            // closing resources 
            scn.close(); 
            dis.close(); 
            dos.close(); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
} 