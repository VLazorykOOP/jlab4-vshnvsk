import java.io.*;
import java.util.*;
public class Task2 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);

        String inputPath = null;

        while (inputPath == null || !new File(inputPath).isFile()){
            System.out.println("Enter the file path:");
            inputPath = in.nextLine();
            if(!new File(inputPath).isFile()) {
                System.out.println("The file does not exist(");
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))){
            int c;
            System.out.println("Information from file: ");
            while((c = reader.read()) != -1){
                System.out.print((char)c);
            }
        } catch (IOException e){
            System.out.println("Error reading data from file: " + e.getMessage());
        }

        System.out.println();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))){
            String line;
            System.out.println("Result: ");
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\2 курс\\Java\\lab4_task2\\result.txt"))){
                while ((line = reader.readLine()) != null){
                    String[] words = line.split(" ");
                    for (String word : words){
                        System.out.print(word);
                        writer.write(word);
                    }
                }
            }catch (IOException e){
                System.out.println("Error reading data from file: " + e.getMessage());
            }
        } catch (IOException e){
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }
}
