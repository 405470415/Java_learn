package com.atguigu.IO_Stream;


import org.junit.Test;

import java.io.*;

public class Test00_first {
    public static void main2(String[] args) throws IOException {
        //1. 创建字节流
        FileInputStream fis = new FileInputStream("C:\\Users\\Hxy\\Desktop\\1.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hxy\\Desktop\\3.txt");
        //2. 写入读出
        //2.1 创建缓冲字节数组  缓冲池
        byte[] data = new byte[1024];
        //2.2 字节长度
        int len;
        //循环读出
        while ((len = fis.read(data)) != -1) {
            fos.write(data, 0, len);
        }
        //3. 关闭流
        fos.close();
        fis.close();
    }

    public static void main1(String arg[]) throws IOException {
        //1. 创建流对象
        //1.1 指定数据源
        FileInputStream fis = new FileInputStream("C:\\Users\\Hxy\\Desktop\\1.txt");//文件必须存在
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hxy\\Desktop\\2.txt");//自动创建文件，已有文件自动覆盖
        //2. 读写数据
        //2.1 定义数组
        byte[] data = new byte[1024];
        //2.2 定义长度
        int len;
        //2.3 循环读取
        while ((len = fis.read(data)) != -1) {
            //2.4 写数据
            fos.write(data, 0, len);
        }
        //3.关闭资源
        fos.close();
        fis.close();
    }

    public static void main3(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\Hxy\\Desktop\\1.txt");
        FileWriter fw = new FileWriter("C:\\Users\\Hxy\\Desktop\\4txt");

        char[] data = new char[1024];
        int len;

        while ((len = fr.read(data)) != -1) {
            fw.write(data, 0, len);
        }

        fw.close();
        fr.close();
    }

    public static void main4(String[] args) throws IOException {
        //1. 创建流对象
        //1.1 指定数据源
        FileInputStream fis = new FileInputStream("C:\\Users\\Hxy\\Desktop\\1.txt");
        //1.2 使用缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        //1.3 指定目的地
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hxy\\Desktop\\5.txt");
        //1.4 使用包装流
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //2. 读写数据
        //2.1 数组 ，缓冲
        byte[] data = new byte[1024];
        //2.2 长度
        int len;
        //2.3 循环读取
        while ((len = bis.read(data)) != -1) {
            bos.write(data,0,len);
        }

        //3. 关闭流资源
        bos.close();
        fos.close();
        bis.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException { //转换流
        //1. 定义 文件路径
        String srcFile = "file_gbk.txt";
        String destFile = "file_utf8.txt";
        //2. 创建流对象
        //2.1 转换输入流，指定GBK编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "GBK");
        //2,2 转换输出流 默认 utf8 编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destFile),"UTF-8");
        //3. 读写数据
        //3.1 数组  字符 （字符才有编码格式）
        char[] buf = new char[1024];

        //3.2 长度
        int len;
        //3.3 循环输入
        while ((len =isr.read(buf)) != -1){
            osw.write(buf,0,len);
        }
        //4. 释放资源
        osw.close();
        isr.close();

    }
}
