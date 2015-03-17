import java.net.*;
import java.io.*;
public class Server {
  
  public static void main(String[] args)
  {
        
    try
    {
      String msg;
      Socket s;
      ServerSocket ser=new ServerSocket(4000);
      System.out.println("SERVER LISTENING!!!\n");
      s=ser.accept();
      BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

      OutputStream o=s.getOutputStream();
      DataOutputStream out=new DataOutputStream(o);
    
      InputStream i=s.getInputStream();
      DataInputStream in=new DataInputStream(i);
         //System.out.println("ADDITION\n");
        int c1,c2;
        //msg=br.readLine();
        c1=in.readInt();
        c2=in.readInt();
        System.out.println("c1="+c1);
        System.out.println("c2="+c2);

        System.out.println();
        System.out.println("ADDITION\n");
        int add=c1+c2;
        System.out.println("c1+c2="+add);
        System.out.println("\nMULTIPLICATION\n");
        int mul=c1*c2;
        System.out.println("c1*c2="+mul);
 
        out.writeInt(add);
        out.writeInt(mul);
    

    }
    
    catch (Exception e)
    {
      e.printStackTrace();
    }
    
    
  }

}
