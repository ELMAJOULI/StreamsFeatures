package ma.elmajouli.stream.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String feature = "ATOS";
       ReadRecord.LineReader(new File("src\\dataSet.bat")).stream().forEach(record -> System.out.println(record));
        Map<String, Double> var = ReadRecord.MapRows(ReadRecord.LineReader(new File("src\\dataSet.bat")), feature);
        Map<String,Double> map = new HashMap<>();
        Map<String, ArrayList<Double>> collection =  ReadRecord.SumAll(ReadRecord.LineReader(new File("src\\dataSet.bat")),0);
        for (Map.Entry<String, ArrayList<Double>> entry: collection.entrySet()){
            Double sum = entry.getValue().stream().reduce((double) 0, Double::sum);
            map.put(entry.getKey(),sum);
        }
        for(Map.Entry<String,Double> entry : map.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }

        System.out.println("the value "+var.get(feature));


    }
}
