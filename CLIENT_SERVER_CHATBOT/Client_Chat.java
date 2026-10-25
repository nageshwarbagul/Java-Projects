
package CLIENT_SERVER_CHATBOT;

import java.net.*;
import java.io.*;

 public class Client_Chat
{
    public static void main(String args[]) throws Exception 
    {
        FileWriter fwobj = new FileWriter("Client_Chat.txt");

        System.out.println("client application is running...");

        Socket sobj = new Socket("localhost", 3100);

        System.out.println("connection is successful with server");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("..........................................");
        System.out.println("................chat client...........");
        System.out.println("..........................................");

        String str1 = null, str2 = null;
        System.out.println("enter massage for server:");

        while (!(str1 = bobj2.readLine()).equals("end")) {
            pobj.println(str1);
            str2 = bobj1.readLine();
            fwobj.write("server says: " + str2 + "\n");
            System.out.println("server says:" + str2);
            System.out.println("enter massage for server:");

        }
        sobj.close();
        fwobj.close();

    }

}
