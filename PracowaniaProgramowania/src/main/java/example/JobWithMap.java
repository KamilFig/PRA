package example;

import org.quartz.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.util.*;


@PersistJobDataAfterExecution
public class JobWithMap {


    Map<Integer, String> query = new TreeMap<Integer, String>();
    Set<Map.Entry<Integer, String>> entrySet = query.entrySet();

    public void add(int Nr, String Zapytanie) throws FileNotFoundException {


        query.put(Nr, Zapytanie);
        final PrintWriter zapis = new PrintWriter("odp.txt");
      //  System.out.println("Ilość zapytan: " + query.size());

        Set<Integer> keySet = query.keySet();
       // System.out.println("Klucze:\n" + keySet);
        Collection<String> values = query.values();
     //   System.out.println("Wartości:\n" + values);


        //Timer
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
               // System.out.println("Ilość zapytan: " + query.size());

                Set<Integer> keySet = query.keySet();
              //  System.out.println("Klucze:\n" + keySet);
                Collection<String> values = query.values();
               // System.out.println("Wartości:\n" + values);

                Set<Map.Entry<Integer, String>> entrySet = query.entrySet();
                for (Map.Entry<Integer, String> entry : entrySet) {

                  //  System.out.println(entry.getKey() + "  " + entry.getValue());
                    zapis.println(entry.getKey() + " " + entry.getValue());


                }

                zapis.close();
            }
        };

        t.schedule(tt, 30000, 30000);

    }


    public String odczyt(String Zapytanie) {

        int intSelect = Zapytanie.toUpperCase().indexOf("SELECT");
        int intFrom = Zapytanie.toUpperCase().indexOf("FROM");
        int intWhere = Zapytanie.toUpperCase().indexOf("WHERE");
        int intOrder = Zapytanie.toUpperCase().indexOf("ORDER BY");

        if (intSelect == 0) {
            if (intFrom != -1) {
                if (intWhere == -1 && intOrder == -1) {
                    return "Polecenie poprawne";
                } else if (intWhere == -1 && intOrder != -1) {
                    return "Błąd polecenie nie zostało zapisane : Brak Where przed Order By";
                } else if (intWhere != -1 && intFrom < intWhere) {
                    if (intOrder == -1 || intWhere < intOrder) {
                        return "Polecenie poprawne";
                    } else {
                        return "Błąd polecenie nie zostało zapisane ";
                    }

                } else {
                    return "Błąd polecenie nie zostało zapisane ";
                }
            } else {
                return "Błąd polecenie nie zostało zapisane: Brak From";
            }
        } else {
            return "Błąd polecenie nie zostało zapisane: Brak Select";
        }


    }

    /*public void execute(JobExecutionContext context) throws JobExecutionException {
        {




            JobKey key = context.getJobDetail().getKey();
            JobDataMap dataMap = context.getJobDetail().getJobDataMap();

            String Zapytanie = dataMap.getString("Zapytanie");
            int Numerek = dataMap.getInt("Numer");

            System.out.println(Zapytanie);
            System.out.println(Numerek);
            query.put(Numerek, Zapytanie);



                try {
                    PrintWriter zapis = new PrintWriter("odp.txt");


                    Set<Integer> keySet = query.keySet();
                    // System.out.println("Klucze:\n" + keySet);
                    Collection<String> values = query.values();
                    //   System.out.println("Wartości:\n" + values);

                    for (Map.Entry<Integer, String> entry : entrySet) {

                        System.out.println(entry.getKey() + "  " + entry.getValue());
                       zapis.println(entry.getKey() + " " + entry.getValue());


                    }

                    zapis.close();
                } catch (FileNotFoundException se) {
                    se.printStackTrace();


                }








        }

        }*/
    }





