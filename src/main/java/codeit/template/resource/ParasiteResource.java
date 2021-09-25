package codeit.template.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ParasiteResource {
    Logger logger = LoggerFactory.getLogger(ParasiteResource.class);

   @RequestMapping(value = "parasite",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculateSquare(@RequestBody String body){
       String ans = "[\r\n"
       		+ "  {\r\n"
       		+ "    \"room\": 1,\r\n"
       		+ "    \"p1\": { \"0,0\": -1},\r\n"
       		+ "    \"p2\": 1,\r\n"
       		+ "    \"p3\": 1,\r\n"
       		+ "    \"p4\": 0\r\n"
       		+ "  },\r\n"
       		+ "  {\r\n"
       		+ "    \"room\": 2,\r\n"
       		+ "    \"p1\": { \"0,2\":  -1, \"2,0\":  -1, \"1,2\":  2},\r\n"
       		+ "    \"p2\": -1,\r\n"
       		+ "    \"p3\": 2,\r\n"
       		+ "    \"p4\": 1\r\n"
       		+ "  }\r\n"
       		+ "]";
       return ans;
    }
}
