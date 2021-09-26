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

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class StonksResource {
    Logger logger = LoggerFactory.getLogger(StonksResource.class);

   @RequestMapping(value = "stonks",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LinkedHashMap<String, Object>[] calculate(@RequestBody String body){
	   System.out.println(body);
	   JSONArray obj = new JSONArray(body);
	   for(Object i: obj) {
		   JSONObject Here = new JSONObject(i.toString());
		   JSONObject tmp = new JSONObject(Here.get("timeline").toString());
		   
	   }
	   
	   LinkedHashMap<String, Object>[] ans = new LinkedHashMap[obj.length()];
	   return ans;
    }
}
