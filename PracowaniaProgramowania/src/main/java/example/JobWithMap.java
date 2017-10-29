package example;

import org.quartz.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.Map;
import java.util.Set;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@PersistJobDataAfterExecution
public class JobWithMap implements Job {

     Map<Integer, String> query = new TreeMap<Integer, String>();
    Set<Map.Entry<Integer, String>> entrySet = query.entrySet();




    public void add(int n, String cos) {

         query.put(n,cos);
        System.out.println("Ilość zapytan: " + query.size());

        Set<Integer> keySet = query.keySet();
        System.out.println("Klucze:\n" + keySet);
        Collection<String> values = query.values();
        System.out.println("Wartości:\n" + values);


        for (Map.Entry<Integer, String> entry : entrySet) {

            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

    }
    public void  execute(JobExecutionContext context) throws JobExecutionException{
        {
           try
            {
                query.put(1,"cos");
                query.put(2,"cos2");

                PrintWriter zapis = new PrintWriter("odp.txt");
                for (Map.Entry<Integer, String> entry : entrySet) {

                    System.out.println("Odczyt" + entry.getKey() + "  " + entry.getValue());


                    zapis.println(entry.getKey() + " " + entry.getValue());

                }
                zapis.close();
            }
            catch(FileNotFoundException se)
            {
                se.printStackTrace();



            }

        }

    }
}


