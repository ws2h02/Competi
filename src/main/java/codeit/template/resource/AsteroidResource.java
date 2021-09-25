package codeit.template.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class AsteroidResource {
    Logger logger = LoggerFactory.getLogger(AsteroidResource.class);

   @RequestMapping(value = "asteroid",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculate(@RequestBody Map<String, String[]> body){
	  String[] input = body.get("test_cases");
	  ArrayList<String> Data = new ArrayList<String>();
	  for (String temp : input) {
	    	Data.add(temp);
	  }
       
	  String ans = "[\r\n";
	  
	  for (String temp : Data) {
		  ArrayList<String> Analy = new ArrayList<String>();
		  ans += "  {\r\n" + "    \"input\": \"" + temp + "\",\r\n";
		  char[] array = temp.toCharArray();
		  int cout = 1;
		  for (int i = 0; i < array.length; i++) {
			  if(i != 0) {
				  if(array[i] == array[i-1]) {
					  cout += 1;
				  }else {
					  String record= String.valueOf(array[i-1]) + String.valueOf(cout);
					  Analy.add(record);
					  cout = 1;
				  }
			  }
		  }
		  Analy.add(String.valueOf(array[array.length-1]) + String.valueOf(cout));
		  

		  int start = (int) Math.floor(Analy.size()/2);
		  double score = Integer.valueOf(Analy.get(start).charAt(1)) - 48;
		  int pre = start-1;
		  int aft = start+1;
		  while(pre >= 0) {
			  int multi = Integer.valueOf(Analy.get(pre).charAt(1)) - 48 + Integer.valueOf(Analy.get(aft).charAt(1)) - 48;
			  pre -= 1;
			  aft += 1;
			  if(multi <= 6) {
				  score += multi;
			  }else if(multi <= 9) {
				  score += multi*1.5;
			  }else if(multi >= 10) {
				  score += multi*2;
			  }
		  }
		  
		  BigDecimal d = new BigDecimal(score);
		  d.stripTrailingZeros();
		  System.out.println(d);
		  ans += "\"score\": " + d +",\r\n";
		  
		  int origin = (int) Math.floor((Integer.valueOf(Analy.get(start).charAt(1)) - 48)/2);
		  for(int i = 0; i < start; i++) {
			  origin += Integer.valueOf(Analy.get(i).charAt(1)) - 48;
		  }
		  
		  System.out.println("Here"+ origin);
		  ans += "    \"origin\": " + origin +"\r\n" + "  },\r\n";
	  }
	  ans = ans.substring(0, ans.length()-3);
	  ans += "]";
	  
	  
      return ans;
    }
}
