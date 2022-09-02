package com.atguigu.IO_Stream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test01_Acount {

    public static void main(String[] args) throws IOException {
        Account.setRate(0.035);
        Account account = new Account("11111", 10000);
        System.out.println("account = " + account);

        FileOutputStream fos = new FileOutputStream("bank.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(account);

        oos.close();
        fos.close();
    }
}

