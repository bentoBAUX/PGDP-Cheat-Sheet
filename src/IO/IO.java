package IO;

import java.io.*;

public class IO {
    public static void readFile(String filename){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void writeFile(){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("exampleBW.txt"));
            bw.write("Hello, Buffered Writer");
            bw.newLine();
            bw.write("This is a simple demo");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if(bw != null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        writeFile();
        readFile("exampleBW.txt");
    }
}
