package CLIENT_SERVER_CHATBOT;

import java.net.*;
import java.io.*;

public class Server_Chat {
    public static void main(String args[]) throws Exception 
    {
       
        FileWriter fwobj = new FileWriter("Server_Chat.txt");


        System.out.println("server application is running...");
        ServerSocket ssobj = new ServerSocket(3100);
        System.out.println("server is waiting is at port at 3100");
        Socket sobj = ssobj.accept();
        System.out.println("client request gets accepted successfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("..........................................");
        System.out.println("................... chat server...........");
        System.out.println("..........................................");

        String str1=null,str2=null;
        while((str1=bobj1.readLine())!=null)
        {
           System.out.println("client says:"+str1);
           fwobj.write("client says: " + str1 + "\n");
           System.out.println("enter massaage for client:");
           str2=bobj2.readLine();
           pobj.println(str2);
        }
        sobj.close();
        ssobj.close();
        fwobj.close();

    }
}
