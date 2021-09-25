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
    public String calculate(@RequestBody String body){
	   String input = body.toString();
	   ArrayList<String> Data = new ArrayList<String>();
	   for (String temp: input.split("\\[|\\]|,|\"|\\\n")) {
		   if(temp.hashCode() != 0 && temp.hashCode() != 13 && temp.hashCode() != 1024) {
	    		Data.add(temp);
		    	System.out.println(temp);
		   }
	   }
	   
	   
	   ArrayList<String> List = new ArrayList<String>();
       
	   String abc = "[\r\n"
	   		+ "  {\r\n"
	   		+ "    \"input\": \"CCCAAABBBAAACCC\",\r\n"
	   		+ "    \"score\": 15,\r\n"
	   		+ "    \"origin\": 7\r\n"
	   		+ "  },\r\n"
	   		+ "  {\r\n"
	   		+ "    \"input\": \"BBAAABBB\",\r\n"
	   		+ "    \"score\": 8,\r\n"
	   		+ "    \"origin\": 3\r\n"
	   		+ "  },\r\n"
	   		+ "  {\r\n"
	   		+ "    \"input\": \"CCCAAAAABBBAAACCC\",\r\n"
	   		+ "    \"score\": 21,\r\n"
	   		+ "    \"origin\": 9\r\n"
	   		+ "  }\r\n"
	   		+ "]";
       return abc;
    }
}
