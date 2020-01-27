import java.util.*;

class CompLastNames implements Comparator<String>{
    public int compare(String aStr, String bStr){
        int i, j;

        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

class TreeMapDemo2A{
    public static void main(String args[]){
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst = compLN.thenComparing((a,b)->a.compareToIgnoreCase(b));

        TreeMap<String, Double> tm = new TreeMap<String,Double>(compLastThenFirst);
        
        tm.put("John Dou", new Double(3434.34));
        tm.put("Tom Smith", new Double(123.22));
        tm.put("Jane Baker", new Double(46569.1));
        tm.put("Samantha Baker", new Double(27169.53));
        
        Set<Map.Entry<String,Double>> set = tm.entrySet();

        for(Map.Entry<String,Double> s : set){
            System.out.println(s.getKey()+" "+s.getValue());
        }

        double balance = tm.get("Tom Smith");
        tm.put("Tom Smith", balance+448960);
        System.out.println("New Balance for \"Tom Smith\": "+tm.get("Tom Smith"));
    }
}