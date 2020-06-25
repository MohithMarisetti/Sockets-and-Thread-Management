import java.io.*; 
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.net.*; 

public class server
{ 
	//static int id=1001;
	long unique_id=0;
	ServerSocket ss = null;
    Socket s = null; 
    JTextArea ta;
	
	/*
	public static void main(String args[])
	{
		new server(new JTextArea());
	}
*/
			
//    public static void main(String[] args)  throws IOException  
 @SuppressWarnings("resource")
public server(JTextArea ta)
	{
    this.serverRun(ta);   
	
    } 
 
 public void serverRun(JTextArea ta)
 {
	 ServerSocket ss=this.ss;
        Socket s=this.s;
         this.ta= ta;
        
		try {
			ss = new ServerSocket(5056);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 

        while (true)  	
        { 
              
            try  {
            
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                  
                //System.out.println("A new client is connected : " + s); 
                 //prevText = l.getText();
               // l.setText(prevText+"\nA new client is connected : " + s);
                
                
                
                
                
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                // create a new thread object 
                Thread t = new ClientHandler(s, dis, dos, ta); 
                this.unique_id =  t.getId();
                
                
               
                
				//new server();
                //Invoking the start() method 
                t.start(); 
               
                  
            } 
            catch (Exception e){ 
                try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
                e.printStackTrace(); 
            } 
        } 
 }
 
} 
  
// ClientHandler class 
class ClientHandler extends Thread  
{ 
  
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    String name="";
    JTextArea ta;
    boolean first = true;
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, JTextArea ta)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
        this.ta = ta;
    } 
  
    @Override
    public void run()  
    { 
        String received=null; 
        String toreturn; 
        String name;
        if(this.first=true)
        {
        	ta.append("\nA client with ID: "+getId()+" connected!");
        	this.first = false;
        }

	    try {
        	dos.writeUTF("Give me your name");
			name = dis.readUTF();
			System.out.println("The name is "+name);
			this.name = name;
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
        while (true)  
        { 
            try { 
  
                // Ask user what he wants 
                dos.writeUTF("give me a number? yes/no\n"); 
                  
                // receive the answer from client 
                
				
				


				//while(received==null)
				received = dis.readUTF(); 
               System.out.println(received);

                if(received.contains("no")) 
                {
                	String text =  ta.getText();
                	String delText = "A client with ID: "+getId()+" connected!";
                	 String newText = text.replace(delText, "");
                	 ta.setText(newText);
                	 
                	 
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 
                  
                  
                // write on output stream based on the 
                // answer from the client 
       
                
				
				
				
				
/*				Random rand = new Random(); 
                int sleepTime = rand.nextInt(10)+5;      */
                
				
				
				
				int sleepTime = Integer.parseInt(received);
				int sleepTimeinSeconds = sleepTime*1000;
                try {
					Thread.sleep(sleepTimeinSeconds);
					dos.writeUTF("server waited for "+new Integer(sleepTime).toString()+" seconds");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (Exception e) { 
				//this.s.close();
                //e.printStackTrace(); 
            }
        } 
          
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 


