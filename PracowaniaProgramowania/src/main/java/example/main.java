package example;
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

public class main extends  JobWithMap{


    public static void main(String[] args) throws InterruptedException,FileNotFoundException {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(JobWithMap.class)
                    .withIdentity("myJob", "group1") // name "myJob", group "group1
                    .build();

            JobDetail job1 = newJob(Odliczanie.class)
                    .withIdentity("myJob1", "group2")
                    .build();
            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(cronSchedule("0/30 * * ? * *"))
                    .build();

            Trigger trigger1 = newTrigger()
                    .withIdentity("trigger2", "group2")
                    .startNow()
                    .withSchedule(cronSchedule("0 * * ? * MON,TUE,WED,THU,FRI *"))
                    .build();
            // Tell quartz to schedule the job using our trigger

            // and start it off
            scheduler.start();

            scheduler.scheduleJob(job, trigger);

            scheduler.scheduleJob(job1, trigger1);
            JobWithMap d = new JobWithMap();
            JobWithMap a = new JobWithMap();


            String imie;
            int zmienna;
            System.out.println("Podaj najpierw numer zadania ,a następnie polecenie SQL , wpisanie 0  konczy działanie programu");
            do {

                Scanner odczyt1 = new Scanner(System.in);
                Scanner odczyt = new Scanner(System.in);
                zmienna = odczyt1.nextInt();
                if (zmienna == 0) {
                    scheduler.shutdown();
                    break;


                }
                imie = odczyt.nextLine();
               System.out.println(a.odczyt(imie));
                if ((zmienna != 0) && a.odczyt(imie) =="Polecenie poprawne") {
                    d.add(zmienna, imie);
                }
            }
            while (zmienna != 0);



        } catch (SchedulerException se) {
            se.printStackTrace();
        }




        }
        /*final Map<Integer, String> query = new TreeMap<Integer, String>();

        final PrintWriter zapis = new PrintWriter("odp.txt");


        //Timer
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Ilość zapytan: " + query.size());

                Set<Integer> keySet = query.keySet();
                System.out.println("Klucze:\n" + keySet);
                Collection<String> values = query.values();
                System.out.println("Wartości:\n" + values);

                Set<Map.Entry<Integer, String>> entrySet = query.entrySet();
                for (Map.Entry<Integer, String> entry : entrySet) {

                    System.out.println(entry.getKey() + "  " + entry.getValue());
                    zapis.println(entry.getKey() + " " + entry.getValue());


                }

            }
      };

        t.schedule(tt, 10000, 10000);
    ////


        String imie;
        int zmienna;


        do {

            Scanner odczyt1 = new Scanner(System.in);
            Scanner odczyt = new Scanner(System.in);
            zmienna = odczyt1.nextInt();
            if (zmienna == 0) {
                tt.cancel();
                break;

            }
            imie = odczyt.nextLine();

            if (zmienna != 0) {
                query.put(zmienna, imie);
            }
        }
        while (zmienna != 0);




        zapis.close();
    }

*/

    }