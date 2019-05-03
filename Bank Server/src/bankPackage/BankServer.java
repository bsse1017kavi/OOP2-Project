package bankPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BankServer
{
    private ArrayList<Account> accounts;
    File file = new File("accounts.txt");

    public void createAccount(String username,String password,double balance) throws IOException,ClassNotFoundException
    {
        Account account = new Account(username,password,balance);

        try
        {
            FileInputStream fstream = new FileInputStream(file);

            ObjectInputStream inputStream = new ObjectInputStream(fstream);
            accounts = (ArrayList<Account>) inputStream.readObject();
            accounts.add(account);

            fstream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(accounts);
        }catch(FileNotFoundException e)
        {
            accounts = new ArrayList<>();
            accounts.add(account);

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(accounts);
        }

    }

    public Account validate(String username,String password) throws IOException,ClassNotFoundException
    {
        try {
            FileInputStream fstream = new FileInputStream(file);


            ObjectInputStream inputStream = new ObjectInputStream(fstream);
            accounts = (ArrayList<Account>) inputStream.readObject();

            for(Account account:accounts)
            {
                if(account.getUsername().equals(username) && account.getPassword().equals(password))
                    return account;
            }

            return null;
        }catch (FileNotFoundException e)
        {

        }

        return null;
    }

    private void showAccounts() throws Exception
    {
        FileInputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        accounts = (ArrayList<Account>) objectInputStream.readObject();

        for(Account account:accounts)
        {
            System.out.println(account);
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception
    {
        int mode;
        String packet,username,password;
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket;

        //mode = sc.nextInt();

        BankServer bankServer = new BankServer();

        while(true)
        {
            //bankServer.showAccounts();
            //System.out.println("It's Working");

            socket = serverSocket.accept();

            Scanner sc = new Scanner(socket.getInputStream());
            PrintStream printStream = new PrintStream(socket.getOutputStream());

            packet = sc.nextLine();

            System.out.println(packet);

            String [] firstSplit = packet.split("~");

            String [] secondSplit;

            mode = Integer.parseInt(firstSplit[0]);

            if(mode==1)
            {
                secondSplit = firstSplit[1].split("`");
                username = secondSplit[0];
                password = secondSplit[1];
                double balance = Double.parseDouble(secondSplit[2]);

                //System.out.println(username+" "+password+" "+balance);

                bankServer.createAccount(username,password,balance);
            }

            else if(mode==2)
            {
                secondSplit = firstSplit[1].split("`");
                username = secondSplit[0];
                password = secondSplit[1];

               Account account = bankServer.validate(username,password);
               System.out.println(account);
            }

            else if(mode==3)
            {
                secondSplit = firstSplit[1].split("`");
                username = secondSplit[0];
                password = secondSplit[1];

                Account account = bankServer.validate(username,password);
                boolean confirmation = false;
                if(account!=null && account.getBalance()>=100) confirmation = true;
                //account.withdraw(100);
                System.out.println(confirmation);
                printStream.println(confirmation);
                //System.out.println(account);
            }

            socket.close();
        }
    }
}
