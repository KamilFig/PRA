package example;

import org.quartz.*;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

@PersistJobDataAfterExecution
public class Odliczanie implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        {
            Calendar cal = Calendar.getInstance();
            Date d = cal.getTime();

            //8.15 - 9.45
            Calendar cal1 = Calendar.getInstance();
            cal1.set(Calendar.HOUR_OF_DAY,8);
            cal1.set(Calendar.MINUTE,15);
            Date d1 = cal1.getTime();
            cal1.add(Calendar.HOUR_OF_DAY,1);
            cal1.add(Calendar.MINUTE,30);
            Date d2 = cal1.getTime();
            //10.00 - 11.30
            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.HOUR_OF_DAY,10);
            cal2.set(Calendar.MINUTE,0);
            Date d3 = cal2.getTime();
            cal2.add(Calendar.HOUR_OF_DAY,1);
            cal2.add(Calendar.MINUTE,30);
            Date d4 = cal2.getTime();
            //11.45 - 13.15
            Calendar cal3 = Calendar.getInstance();
            cal3.set(Calendar.HOUR_OF_DAY,11);
            cal3.set(Calendar.MINUTE,45);
            Date d5 = cal3.getTime();
            cal3.add(Calendar.HOUR_OF_DAY,1);
            cal3.add(Calendar.MINUTE,30);
            Date d6 = cal3.getTime();
            //13:45 - 15:15
            Calendar cal4 = Calendar.getInstance();
            cal4.set(Calendar.HOUR_OF_DAY,13);
            cal4.set(Calendar.MINUTE,45);
            Date d7 = cal4.getTime();
            cal4.add(Calendar.HOUR_OF_DAY,1);
            cal4.add(Calendar.MINUTE,30);
            Date d8 = cal4.getTime();
            //15:30 - 17:00
            Calendar cal5 = Calendar.getInstance();
            cal5.set(Calendar.HOUR_OF_DAY,15);
            cal5.set(Calendar.MINUTE,30);
            Date d9 = cal5.getTime();
            cal5.add(Calendar.HOUR_OF_DAY,1);
            cal5.add(Calendar.MINUTE,30);
            Date d10 = cal5.getTime();
            //17.15 - 18:45
            Calendar cal6 = Calendar.getInstance();
            cal6.set(Calendar.HOUR_OF_DAY,17);
            cal6.set(Calendar.MINUTE,15);
            Date d11 = cal6.getTime();
            cal6.add(Calendar.HOUR_OF_DAY,1);
            cal6.add(Calendar.MINUTE,30);
            Date d12 = cal6.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");




           if((d.after(d1)|| d.equals(d1)) && (d.before(d2) || d.equals(d2)))
            {
                SimpleDateFormat godzin = new SimpleDateFormat("HH");
                SimpleDateFormat minut = new SimpleDateFormat("mm");
                cal1.add(Calendar.HOUR, -1);
                Date oneHourBack = cal1.getTime();
                long dif = oneHourBack.getTime() - d.getTime();

                System.out.println("Do konca zajec pozosotalo : "+godzin.format(dif) +" godzin i " +minut.format(dif)+" minut");
            }
           else if(d.after(d2) && d.before(d3))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");

               long dif = d3.getTime() - d.getTime();

               System.out.println("Do konca przerwy pozosotalo : " +minut.format(dif)+" minut");
           }
            else  if((d.after(d3)|| d.equals(d3)) && (d.before(d4) || d.equals(d4)))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");
               cal2.add(Calendar.HOUR, -1);
               Date oneHourBack = cal2.getTime();
               long dif = oneHourBack.getTime() - d.getTime();

               System.out.println("Do konca zajec pozosotalo : "+godzin.format(dif) +" godzin i " +minut.format(dif)+" minut");
           }
           else if(d.after(d4) && d.before(d5))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");

               long dif = d5.getTime() - d.getTime();

               System.out.println("Do konca przerwy pozosotalo : " +minut.format(dif)+" minut");
           }
           else if((d.after(d5)|| d.equals(d5)) && (d.before(d6) || d.equals(d6)))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");
               cal3.add(Calendar.HOUR, -1);
               Date oneHourBack = cal3.getTime();
               long dif = oneHourBack.getTime() - d.getTime();

               System.out.println("Do konca zajec pozosotalo : "+godzin.format(dif) +" godzin i " +minut.format(dif)+" minut");
           }
           else if(d.after(d6) && d.before(d7))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");

               long dif = d7.getTime() - d.getTime();

               System.out.println("Do konca przerwy pozosotalo : " +minut.format(dif)+" minut");
           }
           else   if((d.after(d7)|| d.equals(d7)) && (d.before(d8) || d.equals(d8)))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");
               cal4.add(Calendar.HOUR, -1);
               Date oneHourBack = cal4.getTime();
               long dif = oneHourBack.getTime() - d.getTime();

               System.out.println("Do konca zajec pozosotalo : "+godzin.format(dif) +" godzin i " +minut.format(dif)+" minut");
           }
           else if(d.after(d8) && d.before(d9))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");

               long dif = d9.getTime() - d.getTime();

               System.out.println("Do konca przerwy pozosotalo : " +minut.format(dif)+" minut");
           }
           else   if((d.after(d9)|| d.equals(d9)) && (d.before(d10) || d.equals(d10)))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");
               cal5.add(Calendar.HOUR, -1);
               Date oneHourBack = cal5.getTime();
               long dif = oneHourBack.getTime() - d.getTime();

               System.out.println("Do konca zajec pozosotalo : "+godzin.format(dif) +" godzin i " +minut.format(dif)+" minut");
           }
           else if(d.after(d10) && d.before(d11))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");

               long dif = d11.getTime() - d.getTime();

               System.out.println("Do konca przerwy pozosotalo : " +minut.format(dif)+" minut");
           }
           else  if((d.after(d11)|| d.equals(d11)) && (d.before(d12) || d.equals(d12)))
           {
               SimpleDateFormat godzin = new SimpleDateFormat("HH");
               SimpleDateFormat minut = new SimpleDateFormat("mm");
               cal6.add(Calendar.HOUR, -1);
               Date oneHourBack = cal6.getTime();
               long dif = oneHourBack.getTime() - d.getTime();

               System.out.println("Do konca zajec pozosotalo : "+godzin.format(dif) +" godzin i " +minut.format(dif)+" minut");
           }
           else
           {
               System.out.println("Nie masz już żadnych zajęć");

           }





        }


    }
}
