import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

   
    //String msg;
    public static void main(String args[])throws IOException
    {   
        try
        {
            
      
            Socket s = new Socket("localhost",4000);
	    //String msg;
            int m1,m2,m3,m4,m5,m6,m7;
//            Socket s;
            BufferedReader b,br1,b1,b2,b3,b4,b5,b6,b7;
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);;

	            
	    OutputStream o=s.getOutputStream();
 	    DataOutputStream out=new DataOutputStream(o);

	    InputStream i=s.getInputStream();
            DataInputStream in=new DataInputStream(i);

          //BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));   
          
            System.out.println("Client Started!!!");
            b=new BufferedReader(new InputStreamReader(System.in));
            b1=new BufferedReader(new InputStreamReader(System.in));
            b2=new BufferedReader(new InputStreamReader(System.in));
            b3=new BufferedReader(new InputStreamReader(System.in));
            b4=new BufferedReader(new InputStreamReader(System.in));
            b5=new BufferedReader(new InputStreamReader(System.in));
            b6=new BufferedReader(new InputStreamReader(System.in));
            b7=new BufferedReader(new InputStreamReader(System.in));
            
             //msg=b.readLine();
             //pw.println(msg);
             System.out.print("p:");
             m1=Integer.parseInt(b1.readLine());
             System.out.println();                
             System.out.print("q1:");
             m2=Integer.parseInt(b2.readLine());

             System.out.print("r1:");
             m5=Integer.parseInt(b5.readLine());

             System.out.print("b1:");
             m6=Integer.parseInt(b6.readLine());
             
             System.out.println();
             System.out.print("q2:");
             m3=Integer.parseInt(b3.readLine());

             System.out.print("r2:");
             m7=Integer.parseInt(b7.readLine());

             System.out.print("b2:");
             m4=Integer.parseInt(b4.readLine());
 
             int xor,and,c1,c2;
             xor=m6 ^ m4;

             System.out.println();
             System.out.println("b1 XOR b2="+xor); 
             and=m6 & m4;
             System.out.println("b1 AND b2="+and);
	     System.out.println();
             c1=(m1*m2)+(2*m5)+m6;
             System.out.println("c1="+c1);
             out.writeInt(c1);
	     c2=(m1*m3)+(2*m7)+m4;
             System.out.println("c2="+c2);
             out.writeInt(c2);

             int ma=in.readInt();
	     int mm=in.readInt();
	     System.out.println("The result of c1+c2: "+ma);
	     System.out.println("The result of c1*c2: "+mm);

	     int ans1=ma%m1;
             System.out.println();
             System.out.println("Decrypt : c1%p\n");
	     if (ans1%2==0)
	        System.out.println("Decrypted value is even and the bit value is zero\n");
	     else
	        System.out.println("Decrypted value is odd and the bit value is one\n");
	     int ans2=mm%m1;
             System.out.println("Decrypt : c2%p\n");
	
             if (ans2%2==0)                    
                 System.out.println("Decrypted value is even and the bit value is zero\n");
	     else
	        System.out.println("Decrypted value is odd and the bit value is one\n");
	    
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            
            try
            {
               //mysoc.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
  } 
}
