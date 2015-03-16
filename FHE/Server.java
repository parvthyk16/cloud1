import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Server {

    private ServerSocket serverSocket;

    public static void main(String[] args)
    {
        try
        {
            int port = 5001;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket server = serverSocket.accept();
            System.out.println("Server Started and listening to the port 1890");
            int number[] = new int[25];
 	    int i;
           
  	DataInputStream in =new DataInputStream(server.getInputStream());
  	DataOutputStream out =new DataOutputStream(server.getOutputStream());
	for(i=0;i<10;i++){
          number[i]=in.readInt();
 	  System.out.println(number[i]);
        }		

        int c =number[0]+number[1];
	int d= number[0]*number[1];
	out.writeInt(c);
	out.writeInt(d);

server.close();          
}
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
      
    }
}
