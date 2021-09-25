package codeit.template.resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SHResource {
    Logger logger = LoggerFactory.getLogger(SHResource.class);

   @RequestMapping(value = "stock-hunter",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculate(@RequestBody String body){
	   JSONArray obj = new JSONArray(body);
	   for(Object i:obj) {
		   System.out.println(i);
	   }
	   String ans = "";
       return ans;
    }
}
