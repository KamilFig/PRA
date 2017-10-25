package example;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import example.JobWithMap;
import java.util.Scanner;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
public class sql_query {
    public static void main(String [ ] args) {

        Map<Integer, String> employees = new TreeMap<Integer, String>();
        String imie;
        int zmienna;


        do
        {

            Scanner odczyt1 = new Scanner(System.in);
            Scanner odczyt = new Scanner(System.in);
            zmienna = odczyt1.nextInt();
            if (zmienna== 0 ) {break;}
            imie = odczyt.nextLine();

            if(zmienna!= 0)
            {
                employees.put(zmienna, imie);
            }
        }
        while(zmienna!= 0);



        System.out.println("Ilość pracowników: " + employees.size());

        Set<Integer> keySet = employees.keySet();
        System.out.println("Klucze:\n" + keySet);
        Collection<String> values = employees.values();
        System.out.println("Wartości:\n" + values);

        Set<Entry<Integer,String>> entrySet = employees.entrySet();
        for(Entry<Integer, String> entry: entrySet) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }


    }
}
