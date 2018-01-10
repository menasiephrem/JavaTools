
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import sun.misc.JavaAWTAccess;
import sun.reflect.annotation.TypeAnnotation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menasi
 */
public class MainCLass {
   

static public  void main(String [] arg0)
{
  double [] amestKilo = {9.034806489944458, 38.76299500465393}
          ,cur={9.03603306,38.76631848};
    System.out.println(dis(amestKilo, cur)+"");
}

static long getTime()
{
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date currentDate = new Date(System.currentTimeMillis());
        long date1=1;
        int dir =0;
        int time1=0;
        String time = dateFormat.format(currentDate);
        String [] DateTime = time.split(" ");
        String [] Date = DateTime[0].split("-");
        String [] Time = DateTime[1].split(":");
        time = "";
        for (int i = 0; i < Date.length; i++) {
        time = time+Date[i];   
    }
        date1=Integer.parseInt(time);
        time="";
        for (int i = 0; i < Time.length; i++) {
        time = time+Time[i];
    }
        
      time1 =Integer.parseInt(time);
     
        
    return (date1*10000000)+(time1*10)+dir;
}

private static int getMin(double [] dis)
{
    double shortDistance ;
    shortDistance = dis[0];
    int temp=0;

        for (int j = 0; j<dis.length;j++)
        {
            if(shortDistance >dis[j])
            {  
                shortDistance = dis[j];
                temp = j;
            }
                
        }

    return temp;
}


 private static double dis(double [] st,double [] di)
 {
    
     double lat1= st[0],lon1 = st[1];
     double lat2= di[0],lon2 = di[1];
     double radius = 6371000; //m
     
     double dlat = Math.toRadians(lat2-lat1);
     double dlng = Math.toRadians(lon2-lon1);
     double a = Math.sin(dlat/2)*Math.sin(dlat/2)
               + Math.cos(Math.toRadians(lat1)) *
                     Math.cos(Math.toRadians(lat2))*
             Math.sin(dlng/2)*Math.sin(dlng/2);
     double c = 2* Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
     double d = radius * c;
     
     return d;
 }
}
