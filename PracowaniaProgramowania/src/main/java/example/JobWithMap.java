package example;

import org.quartz.*;

@PersistJobDataAfterExecution
public class JobWithMap implements Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        {

            JobKey key = context.getJobDetail().getKey();

            JobDataMap dataMap = context.getJobDetail().getJobDataMap();

            //read values

            int counter = 0;
            String nazwa = "cos";
            if (dataMap.containsKey("counter")) {
                counter = dataMap.getInt("counter");
                nazwa = dataMap.getString("cos1");
            }
            System.out.println("Instance " + key + " of says: " + " number " + " "+ counter + nazwa);
            counter++;
            //increment and save counter
            dataMap.put("cos1",nazwa);
            dataMap.put("counter", counter);
        }
    }
}
