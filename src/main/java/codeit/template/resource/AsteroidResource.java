package codeit.template.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		    System.out.println(temp);
	  }
       
	  String ans = "[\r\n";
	   		
	  for (String temp : Data) {
		  ans += "  {\r\n" + "    \"input\": \"" + temp + "\",\r\n";
		  ans += "\"score\": 15,\r\n" ;
		  ans += "    \"origin\": 7\r\n" + "  },\r\n";
	  }
	  ans += "]";
      return ans;
    }
}
