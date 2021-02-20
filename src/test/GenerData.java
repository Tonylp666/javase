package test;


import com.sun.xml.internal.stream.writers.WriterUtility;

import java.io.*;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GenerData {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"D:\\myWork\\testdata",""};
//        BASE = args[0];
        GenerData generData = new GenerData();
//        generData.generData();
//        generBigData();

        FileReader fileReader = new FileReader(new File("D:\\temp\\fileabcddd.txt"));
        LineNumberReader numberReader = new LineNumberReader(fileReader);
        numberReader.skip(Long.MAX_VALUE);
        int count = numberReader.getLineNumber();
        System.out.println(count);
    }

    private static String BASE;
    private  long total = 1014*1014*1024*10l;
    
    private  void generGzip(){
        GZIPOutputStream gzipOutputStreamm = null;
        FileInputStream input = null;
        try {
            gzipOutputStreamm = new GZIPOutputStream(new FileOutputStream("./textgzip.gz"));
            while (total > 0){
                input = new FileInputStream(BASE);
                byte[] buffer = new byte[1024*1024];
                int len;
                while ((len = input.read(buffer)) != -1){
                    gzipOutputStreamm.write(buffer,0,len);
                }
                System.out.println(total + "=================");
                total -= len;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                gzipOutputStreamm.flush();
                input.close();
                gzipOutputStreamm.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private  void generData(){
        FileOutputStream outputStream = null;
        FileInputStream input = null;
        try {
            outputStream = new FileOutputStream("./text");
            input = new FileInputStream(BASE);
            while (total > 0){
                byte[] buffer = new byte[1024*1024];
                int len;
                while ((len = input.read(buffer)) != -1){
                    outputStream.write(buffer,0,len);
                    total -= len;
                    if (total < 0){
                        break;
                    }
                }
                input = new FileInputStream(BASE);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                input.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    private static void generBigData() throws IOException {

        try{
        File f = new File("D:\\temp\\fileabcddd.txt");
        if(!f.exists())
            f.createNewFile();
        FileWriter fw = new FileWriter(f,true);
        //fw.write("开始写入\r\n");
        //fw.flush();
        long fileSize = f.length();
        System.out.println("文件大小 "+fileSize);
        Random ran = new Random();
        for(int i=0;i<100;i++){
            fw.write(ran.nextInt(100)+"\r\n");
        }
        fw.flush();
        fw.close();
        System.out.println("写入后文件大小 "+f.length());
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
