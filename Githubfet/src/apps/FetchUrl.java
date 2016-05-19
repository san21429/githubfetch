package apps;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;

public class FetchUrl {
	FetchInt f;
	
	public FetchUrl(FetchInt f)
	{this.f=f;
		
	}
	/* fetches issues from github using their api
	 * */
	 
	public void fetchurl(String urli)
	{ 
		 try { 
			 
			 String ur=urli.split("github.com/")[1];
			 ur="https://api.github.com/repos/"+ur+"/issues?per_page=100000&status=open";
			
			 
		 StringBuilder stringBuilder=new StringBuilder();
	         URL url=new URL(ur);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
          //  httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(10000);

          //  httpURLConnection.getOutputStream().write(stringBuilder.toString().getBytes("utf-8"));
            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder1 = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null)
                    stringBuilder1.append(line);

            
             calculate(stringBuilder1.toString());


            }
            else
            { InputStream inputStream = httpURLConnection.getErrorStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder1 = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null)
                    stringBuilder1.append(line);
               

            }




        } catch (Exception e) {
            e.printStackTrace();
        }
	}
/*Calculate the required issues count and send result back to Fetch class
 * */
 
	private void calculate(String string) 
	{   int totalnum=0,total24=0,total247=0,total7=0;
	
		JSONArray jsonObject=new JSONArray(string);
	    for(int i=0;i<jsonObject.length();i++)
	    { JSONObject js=jsonObject.getJSONObject(i);
	    	if(js.optString("state").equals("open"))
	    	{totalnum++;
	    	 
	    		  Instant instant = Instant.parse (js.optString("created_at")) ;
	    		  Instant instant1 = Instant.now();
	    		  Instant in7=instant1.minus(Duration.ofDays(7));
	    		  instant1=instant1.minus(Duration.ofHours(24));
	    		  if(instant.compareTo(instant1)>=0)
	    			   total24++;
	    		  if(instant.compareTo(instant1)<0&&instant.compareTo(in7)>=0)
	    			   total247++;
	    		  if(instant.compareTo(in7)<0)
	    			   total7++;
	    		
			    //	Date date=format.parse(js.optString("created_at"));
			
	    	
	    		
	    	}
	    	
	    }
	    f.publishresult(totalnum,total24, total247,total7);
	   
		
		// TODO Auto-generated method stub
		
	}

}
