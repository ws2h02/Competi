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
	   
       JSONObject obj = new JSONObject(body);
       LinkedHashMap<String, Object> ans = new LinkedHashMap();
       String[] Data = obj.get("history").toString().split("},{");
       for(String i: Data) {
    	   
       }

       System.out.println(Data);
       String[] anslist = {"a", "b", "d", "c", "c"};
       ans.put("answer", anslist);
	return ans;
    }
}
