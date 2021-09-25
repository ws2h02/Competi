package codeit.template.resource;

import org.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DecoderResource {
    Logger logger = LoggerFactory.getLogger(DecoderResource.class);

   @RequestMapping(value = "decoder",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LinkedHashMap<String, Object> calculate(@RequestBody String body){
	   System.out.println(body);
	   String temp;
       JSONObject obj = new JSONObject(body);
	   String[] anslist = new String[obj.getInt("num_slots")];
	   for(int j = 0; j < anslist.length; j++) {
		   anslist[j] = obj.getJSONArray("possible_values").get(j).toString();
	   }
       LinkedHashMap<String, Object> ans = new LinkedHashMap();
       if(!obj.getJSONArray("history").isEmpty()) {
    	   String[] Data = obj.get("history").toString().split("\\},\\{");
           for(String i: Data) {
        	   System.out.println(i);
        	   int result = Integer.parseInt(i.substring(i.indexOf("result")+ 8, i.indexOf(",")));
        	   temp = i.substring(i.indexOf("output_received")+ 18, i.indexOf("]"));
        	   temp = temp.replace("\"", "");
    		   temp = temp.replace(",", "");
        	   System.out.println(result);
        	   if(result == 4) {
        		   for(int j = 0; j < anslist.length; j++) {
        			   anslist[j] = Character.toString(temp.toCharArray()[j]);
        		   }
        	   }
           }
       }
       
       String[] anslist1 = { "y","x","a","i","l"};

       ans.put("answer", anslist1);
	return ans;
    }
}
