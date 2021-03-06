package codeit.template.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;
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
		  
		  double ans_score = 0;
		  int ans_origin = 0;
		  
		  for(int i = 0; i < Analy.size(); i++) {
			  int start = i;
			  double score;
			  int pre = start-1;
			  int aft = start+1;
			  if(Integer.valueOf(Analy.get(start).substring(1))%2 != 0) {
				  score = Integer.valueOf(Analy.get(start).substring(1));
				  if(score <= 6) {
					  score = score;
				  }else if(score <= 9) {
					  score = score*1.5;
				  }else if(score >= 10) {
					  score = score*2;
				  }
				  while(pre >= 0) {
					  if(aft == Analy.size()) {
						  break;
					  }
					  if(Analy.get(pre).charAt(0) != Analy.get(aft).charAt(0)) {
						  break;
					  }
					  int multi = Integer.valueOf(Analy.get(pre).substring(1)) + Integer.valueOf(Analy.get(aft).substring(1));
					  if(multi <= 6) {
						  score += multi;
					  }else if(multi <= 9) {
						  score += multi*1.5;
					  }else if(multi >= 10) {
						  score += multi*2;
					  }

					  pre -= 1;
					  aft += 1;
				  }
			  }else {
				  score = Integer.valueOf(Analy.get(start).substring(1))-1;
				  if(score <= 6) {
					  score = score;
				  }else if(score <= 9) {
					  score = score*1.5;
				  }else if(score >= 10) {
					  score = score*2;
				  }
			  }
			  

			  int origin = (int) Math.floor((Integer.valueOf(Analy.get(start).substring(1)))/2);
			  for(int j = 0; j < start; j++) {
				  origin += Integer.valueOf(Analy.get(j).substring(1));
			  }
			  
			  if(score > ans_score) {
				  ans_score = score;
				  ans_origin = origin;
			  }
		  }
		  


		  BigDecimal d = new BigDecimal(ans_score);
		  d.stripTrailingZeros();
		  
		  ans += "\"score\": " + d +",\r\n";
		  ans += "    \"origin\": " + ans_origin +"\r\n" + "  },\r\n";
	  }
	  ans = ans.substring(0, ans.length()-3);
	  ans += "]";
	  
	  
      return ans;
    }
}
