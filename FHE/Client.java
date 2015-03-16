import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

   

    public static void main(String args[])throws IOException
    {   
        try
        {
            String host = "localhost";
            int port = 5001;
      
            Socket mysoc = new Socket(host,port);
	    int index = 0;
            int bin1[] = new int[25];
	    int bin2[] = new int[25];	
	    int cipher[] = new int[25];
	    int p = 101;
	    int i;

	            //while(true){
                //Send the message to the server
              
               // OutputStreamWriter osw = new OutputStreamWriter(os);
              //  BufferedWriter bw = new BufferedWriter(osw);
		OutputStream outToServer = mysoc.getOutputStream();
 		DataOutputStream out = new DataOutputStream(outToServer);

		InputStream ser = mysoc.getInputStream();
                DataInputStream in =new DataInputStream(ser);

                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the value for q1 and q2!!");
              	int q1 = Integer.parseInt(bufferRead.readLine());
	 	int q2 = Integer.parseInt(bufferRead.readLine());
		System.out.println("enter the random values for r"); 
 		int r1 = Integer.parseInt(bufferRead.readLine());
                int r2 = Integer.parseInt(bufferRead.readLine());
		System.out.println("enter the random values for b");
      		int n1 = Integer.parseInt(bufferRead.readLine());
		int n2 = Integer.parseInt(bufferRead.readLine());
		
	      while(n1 > 0){
              bin1[index++] = n1%2;
              n1 = n1/2;
              }
 	      while(n2 > 0){
              bin2[index++] = n2%2;
              n2 = n2/2;
              }
              for(i = index-1;i >= 0;i--){
              System.out.print(bin1[i]);
              }
 	      System.out.println("\n");
	      for(i = index-1;i >= 0;i--){
              System.out.print(bin2[i]);
              }
	      System.out.println("\n");

        
		

        for(i=0;i<10;i=i+2){
	cipher[i]=(p*q1)+(2*r1)+(bin1[i]);
        cipher[i+1]=(p*q2)+(2*r2)+(bin2[i]);

        }
	
	for(i=0;i<10;i=i+1){
	out.writeInt(cipher[i]);
	System.out.println(cipher[i]+"\n");}

        int c=in.readInt();
	int d=in.readInt();
	System.out.println("The result of c1+c2: "+c+"\n");
	System.out.println("The result of c1*c2: "+d+"\n");

	int ans1=c%p;
	if (ans1%2==0)
	System.out.println("even and the bit value is equal to zero\n");
	else
	System.out.println("odd and the bit value is equal to one\n");
	int ans2=d%p;
	if (ans2%2==0)
	System.out.println("even and the bit value is equal to zero\n");
	else
	System.out.println("odd and the bit value is equal to one\n");
}

  catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
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
