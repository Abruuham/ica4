import java.lang.reflect.Array;
import java.util.*;

public class Main {

    private static ArrayList<ArrayList<Object>> matrix_one = new ArrayList<>();
    private static ArrayList<ArrayList<Object>> matrix_two = new ArrayList<>();

    public static void main(String[] args) {
        createMatrices();
        System.out.println(MATRIX_ADD(matrix_one, matrix_two, getType(matrix_one)));
    }

    public static void createMatrices(){
        ArrayList<Object> m1 = new ArrayList<>();
        ArrayList<Object> m1_2 = new ArrayList();
        matrix_one.add(m1);
        matrix_one.add(m1_2);
        matrix_one.get(0).add(1);
        matrix_one.get(0).add(2);
        matrix_one.get(1).add(3);
        matrix_one.get(1).add(4);

        ArrayList<Object> m2 = new ArrayList<>();
        ArrayList<Object> m2_2 = new ArrayList<>();
        matrix_two.add(m2);
        matrix_two.add(m2_2);
        matrix_two.get(0).add(5);
        matrix_two.get(0).add(6);
        matrix_two.get(1).add(7);
        matrix_two.get(1).add(8);
    }


    public static ArrayList<ArrayList<Object>> MATRIX_ADD(ArrayList<ArrayList<Object>> m1,
                                                          ArrayList<ArrayList<Object>> m2, String type) {
        ArrayList<ArrayList<Object>> addedArray = new ArrayList<>();
        int m = m1.size();
        int n = m1.get(0).size();
        if(type.equalsIgnoreCase("Invalid!")){
            System.out.println("Inavlid matrix");
            return null;
        }

        if(m == m2.size() && n == m2.get(0).size()) {
            if(type.equals("int")){
                for (int i = 0; i < m1.size(); i++) {
                    ArrayList<Object> sum = new ArrayList<>();
                    for (int j = 0; j < m1.get(i).size(); j++) {
                        int x = (Integer) m1.get(i).get(j) + (Integer) m2.get(i).get(j);
                        sum.add(x);
                    }
                    addedArray.add(sum);
                }
                return addedArray;
            } else if (type.equals("double")){
                for (int i = 0; i < m1.size(); i++) {
                    ArrayList<Object> sum = new ArrayList<>();
                    for (int j = 0; j < m1.get(i).size(); j++) {
                        sum.add((Double)m1.get(i).get(j) + (Double)m2.get(i).get(j));
                    }
                    addedArray.add(sum);
                }
                return addedArray;
            } else if (type.equals("String")){
                for (int i = 0; i < m1.size(); i++) {
                    ArrayList<Object> sum = new ArrayList<>();
                    for (int j = 0; j < m1.get(i).size(); j++) {
                        sum.add((String) m1.get(i).get(j) + (String) m2.get(i).get(j) );
                    }
                    addedArray.add(sum);
                }
                return addedArray;
            } else{
                System.out.println("Invalid matrices");
            }

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

    public static String getType(ArrayList<ArrayList<Object>> objectType) {
        Object value = objectType.get(0).get(0);
        String type = "";
        if (value.getClass().getCanonicalName().equals("java.lang.Integer")) {
            type = "int";
        } else if (value.getClass().getCanonicalName().equals("java.lang.Double")) {
            type = "double";
        } else if (value.getClass().getCanonicalName().equals("java.lang.String")) {
            type = "String";
        } else {
            type = "Invalid!";
        }
        return type;
    }

    private static ArrayList<ArrayList<Object>> MATRIX_ASTERATE(ArrayList<ArrayList<Object>> matrix, String type){
        ArrayList<ArrayList<Object>> total = new ArrayList<>();
        Object a = matrix.get(0).get(0);
        Object b = matrix.get(0).get(1);
        Object c = matrix.get(1).get(0);
        Object d = matrix.get(1).get(1);

        ArrayList first_row = new ArrayList<>();
        ArrayList second_row = new ArrayList<>();

        switch(type){
            case "int":
                first_row.add(asterateInt(a,b,c,d));
                first_row.add(asterateInt(a,b,c,d)) * (int) b *
                        Integer.parseInt(String.valueOf(d) + String.valueOf(d) + String.valueOf(d));
                second_row.add(asterateIntRow2(a,b,c,d) * (int) c *
                        Integer.parseInt(String.valueOf(a) + String.valueOf(a) + String.valueOf(a)));
                second_row.add(asterateIntRow2(a,b,c,d));
                break;
            case "double":
                first_row.add(asterateRowDouble(a,b,c,d));
                first_row.add(asterateRowDouble(a,b,c,d) * (double) b * asterateDouble(d));
                second_row.add(asterateRow2Double(a,b,c,d) * (double) c * asterateDouble(a));
                second_row.add(asterateRow2Double(a,b,c,d));
                break;
            case "String":
                String aString = (String) a;
                ArrayList<String> listA = new ArrayList<String>(Arrays.asList(aString))


        }

        total.add(first_row);
        total.add(second_row);

        return total;
    }


    public static ArrayList<ArrayList<Object>> matrixMultiply(ArrayList<ArrayList<Object>> m1, ArrayList<ArrayList<Object>> m2, String type) {
        ArrayList<ArrayList<Object>> ret = new ArrayList<>();
        int m1Size = m1.size();
        int n = m1.get(0).size();
        if (type.equalsIgnoreCase("Invalid!")) {
            System.out.println("Invalid matrix contents");
            return null;
        }
        if (m1Size == m2.size() && n == m2.get(0).size()) {
            if (type.equals("int")) { // if 'int', normal multiply
                for (int i = 0; i < m1Size; i++) {
                    ArrayList<Object> listForInsertion = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        Integer productSum = 0;
                        for (int k = 0; k < m1Size; k++) {
                            productSum += ((Integer) m1.get(i).get(k) * (Integer) m2.get(k).get(j));
                        }
                        listForInsertion.add(productSum);
                    }
                    ret.add(listForInsertion);
                }
            } else if (type.equals("double")) { // if 'double', divide & truncate to 4 decimal places
                invertMatrix(b);
                for (int i = 0; i < m1Size; i++) {
                    ArrayList<Object> listForInsertion = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        Double productSum = (double) 0;
                        for (int k = 0; k < m1Size; k++) {
                            productSum += ((Double) m1.get(i).get(k) * (Double) m2.get(k).get(j));
                        }
                        decFormat decTruncate = new decFormat("##.####");
                        String reformattedDouble = decTruncate.format(productSum);
                        listForInsertion.add(reformattedDouble);
                    }
                    ret.add(listForInsertion);
                }
            }
            if (type.equalsIgnoreCase("String")) {
                for (int i = 0; i < m1Size; i++) { // if 'string', intersection, with no duplicates
                    ArrayList<Object> listForInsertion = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        listForInsertion.add(intersect((String) a.get(i).get(j), (String) m2.get(i).get(j)));
                    }
                    ret.add(listForInsertion);
                }
            }
        } else {
            System.out.println("Your dimensions are not equal between the two matrices");
        }
        return ret;
    }

    public static void invertMatrix(ArrayList<List<Object>> matrixArray) {
        double zeroIndex = (double)matrixArray.get(0).get(0);
        double firstIndex = (double)matrixArray.get(1).get(1);
        double index1 = (double) matrixArray.get(0).get(1);
        double index2 = (double) matrixArray.get(1).get(0);
        double determinant = 1.0 / ((zeroIndex * firstIndex) - (index1 * index2 ));

        double temporaryArray = zeroIndex;
        matrixArray.get(0).set(0,firstIndex);
        matrixArray.get(1).set(1, temporaryArray);

        matrixArray.get(0).set(1, index1 * -1.0);
        matrixArray.get(1).set(0, index2 * -1.0);

        for (int i = 0; i < matrixArray.size(); i++)
            for (int j = 0; j < matrixArray.size(); j++)
                matrixArray.get(i).set(j, (double) matrixArray.get(i).get(j) * determinant);
    }
}
