package ma.elmajouli.stream.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// this class help to read a file and return a list of element
public class ReadRecord {
public static final int  P_INDEX = 3;
    public static List<String> LineReader(File file){
        ArrayList<String> records = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext())
                records.add(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  records;
    }
    public static Map<String,Double> MapRows(List<String> rows , String feature){
        HashMap<String, Double> mapping = new HashMap<>();
        int sum = rows.stream().filter(row -> row.contains(feature.toUpperCase()))
                .map(row -> row.split("\\|")).mapToInt(e -> Integer.parseInt(e[P_INDEX])).sum();
        mapping.put(feature, Double.valueOf(sum));
        return mapping;
    }
    public static Map<String,ArrayList<Double>> SumAll(List<String> rows, int colNum ){
        HashMap<String,ArrayList<Double>> mapping = new HashMap<>();
        rows.stream().map(row -> row.split("\\|"))
                     .forEach(ste ->{
                         if (!mapping.containsKey(ste[colNum])){
                             ArrayList<Double> doubles = new ArrayList<>();
                             doubles.add(Double.parseDouble(ste[P_INDEX]));
                             mapping.put(ste[colNum],doubles);
                         }
                         else{
                             mapping.get(ste[colNum]).add(Double.parseDouble(ste[P_INDEX]));
                         }
                     });
        return mapping;
    }
}
