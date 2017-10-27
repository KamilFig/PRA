package example;

import org.quartz.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@PersistJobDataAfterExecution
public class JobWithMap implements Job {




    public void execute(JobExecutionContext context) throws JobExecutionException {
        {




            //read values

            JobKey key = context.getJobDetail().getKey();

            JobDataMap dataMap = context.getJobDetail().getJobDataMap();

            int counter = 0;
            String nazwa = "cos";
            if (dataMap.containsKey("counter")) {
                counter = dataMap.getInt("counter");
                nazwa = dataMap.getString("cos1");
            }
            System.out.println("Instance " + key + " of says: " + " number " + " " + counter + nazwa);
            counter++;
            //increment and save counter
            dataMap.put("cos1", nazwa);
            dataMap.put("counter", counter);



            try
            {
                PrintWriter zapis = new PrintWriter("123.txt");

                    zapis.println(counter + "" + nazwa);

                zapis.close();
            }
            catch (FileNotFoundException se) {
                se.printStackTrace();
            }

        }
    }





    }


