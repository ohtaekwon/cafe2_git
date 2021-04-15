package my.otk.ai.test2.voice;

//Cafe2 접속 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class HttpConTest {

public static void main(String[] args) {

   try {
       URL url = new URL("https://openapi.naver.com/v1/search/news");
       HttpURLConnection con = (HttpURLConnection)url.openConnection(); // url과 연결한 
       
       con.setRequestMethod("GET"); //POST요청
       
       con.setDoOutput(true);
       DataOutputStream wr = new DataOutputStream(con.getOutputStream());
       wr.writeBytes(""); //전송
       wr.flush();
       wr.close();
       
       int responseCode = con.getResponseCode();
       BufferedReader br;
       if(responseCode==200) { // 정상 호출
           br = new BufferedReader(new InputStreamReader(con.getInputStream()));
           String inputLine;
           StringBuffer response = new StringBuffer();
           while ((inputLine = br.readLine()) != null) {
               response.append(inputLine);
           }
           br.close();
           System.out.println(response.toString());
       } else {  // 오류 발생
           br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
           String inputLine;
           StringBuffer response = new StringBuffer();
           while ((inputLine = br.readLine()) != null) {
               response.append(inputLine);
           }
           br.close();
           System.out.println(response.toString());
       }
   } catch (Exception e) {
       System.out.println(e);
   }
}
}