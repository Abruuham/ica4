import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<ArrayList<String>> matrix_one = new ArrayList<ArrayList<String>>();
    private static ArrayList<ArrayList<String>> matrix_two = new ArrayList<ArrayList<String>>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createMatrices();

        System.out.print("What function would you like to use (+, x, *): ");
        String function = scanner.next();
        System.out.print("What is the type of input (int, double, string): ");
        String type = scanner.next();
        switch (function) {
            case "+":
                if(type.equals("int")) {
                    System.out.println(MATRIX_ADD_INT(matrix_one, matrix_two));
                } else if (type.equals("string")){
                    System.out.println(MATRIX_ADD_STRING(matrix_one, matrix_two));
                }
                break;
            case "x":
                break;
            case "*":
                break;
            default:
                break;
        }
    }

    public static void createMatrices(){
        System.out.println("Enter the height and width of the first matrix: ");
        int size_one_height = scanner.nextInt();
        int size_one_width = scanner.nextInt();

        System.out.println("Enter the height and width of the second matrix: ");
        int size_two_height = scanner.nextInt();
        int size_two_width = scanner.nextInt();

        createMatrixHelper(matrix_one, size_one_height, size_one_width, 1);
        createMatrixHelper(matrix_two, size_two_height, size_two_width, 2);
    }

    private static void createMatrixHelper(ArrayList<ArrayList<String>> m, int height, int width, int n){
        System.out.println("Enter the values for matrix "+n);
        for(int i = 0; i < height; i++){
            ArrayList<String> first_matrix = new ArrayList<>();
            for(int j= 0; j< width; j++){
                String x = scanner.next();
                first_matrix.add(x);
            }
            m.add(first_matrix);
        }
    }

    public static ArrayList<ArrayList<String>> MATRIX_ADD_INT(ArrayList<ArrayList<String>> m1,
                                                          ArrayList<ArrayList<String>> m2){
        ArrayList<ArrayList<String>> addedArray = new ArrayList<>();
        for(int i = 0; i < m1.size();i++){
            ArrayList<String> sum = new ArrayList<>();
            for(int j = 0; j < m1.get(i).size(); j++){
                int x =Integer.parseInt(m1.get(i).get(j)) + Integer.parseInt(m2.get(i).get(j));
                sum.add(Integer.toString(x));
            }
            addedArray.add(sum);
        }
        return addedArray;
    }

    public static ArrayList<ArrayList<String>> MATRIX_ADD_STRING(ArrayList<ArrayList<String>> m1,
                                                          ArrayList<ArrayList<String>> m2){
        ArrayList<ArrayList<String>> addedArray = new ArrayList<>();
        for(int i = 0; i < m1.size();i++){
            ArrayList<String> sum = new ArrayList<>();
            for(int j = 0; j < m1.get(i).size(); j++){
                String x = m1.get(i).get(j) + m2.get(i).get(j);
                sum.add(x);
            }
            addedArray.add(sum);
        }
        return addedArray;
    }


}
