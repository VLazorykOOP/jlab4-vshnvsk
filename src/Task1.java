import java.util.*;
import java.io.*;
public class Task1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String inputPath = null;

        while (inputPath == null || !new File(inputPath).isFile()){
            System.out.println("Enter the file path:");
            inputPath = in.nextLine();
            if(!new File(inputPath).isFile()) {
                System.out.println("The file does not exist(");
            }
        }

        List<Integer> numbers = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(inputPath))){
            String line;
            while ((line = fileReader.readLine()) != null){
                boolean hasNumber = false;
                int sum = 0;
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0; i < line.length(); i++){
                    char c = line.charAt(i);
                    if(Character.isDigit(c)){
                        hasNumber = true;
                        stringBuilder.append(c);
                    } else {
                        if(stringBuilder.length() > 0){
                            int number = Integer.parseInt(stringBuilder.toString());
                            sum += number;
                            numbers.add(number);
                            stringBuilder = new StringBuilder();
                        }
                    }
                }
                if(stringBuilder.length() > 0){
                    int number = Integer.parseInt(stringBuilder.toString());
                    sum += number;
                    numbers.add(number);
                }
                if(hasNumber){
                    System.out.println(line + " (sum: " + sum + ")");
                } else {
                    letters.add(line);
                }
            }
        }catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }

        Collections.sort(numbers);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(inputPath))){
            for (int number : numbers) {
                writer.write(number + " ");
            }
        } catch (IOException e){
            System.out.println("Error reading data from file: " + e.getMessage());
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\2 курс\\Java\\lab4_task1\\letter.txt"))){
            for(String line : letters){
                writer.write(line + " ");
            }
        } catch (IOException e){
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }
}
