package example;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class main implements Job{
    public void execute(JobExecutionContext context) throws JobExecutionException {
        {
        }}



    public static void main(String[] args) throws FileNotFoundException {

        final Map<Integer, String> query = new TreeMap<Integer, String>();

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
                zapis.close();
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





    }



}