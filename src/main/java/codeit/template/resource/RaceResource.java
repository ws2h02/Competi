package codeit.template.resource;

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
public class RaceResource {
    Logger logger = LoggerFactory.getLogger(RaceResource.class);

   @RequestMapping(value = "fixedrace",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculate(@RequestBody String body){
       System.out.println(body);
       JSONObject Data = new JSONObject();
       String Winner = "Mari Maus,Olive Osgood,Rossana Rackers,Cecila Cribb,Sang Sirois,Olinda Oakley";
       Data.put("Mari Maus", "Caitlin Cully, Charita Collett, Franklin Filippi, Jared Jinkins, Fletcher Felty, Candice Cahill, Francisco Finchum, Tracie Temblador, Leslie Lubinsky");
       Data.put("Olive Osgood", "Astrid Acheson, Candice Cahill, Vanda Vonderheide, Boris Batts, Josiah Jarnagin, Sharyl Shepler, Jewel Jaeger, Colin Crail, Reed Rotolo");
       Data.put("Rossana Rackers", "Zada Zynda, Josiah Jarnagin, Shawn Setliff, Sixta Sulton, Colin Crail, Lemuel Lorenzo, Rebekah Regnier, Duane Darrell, Chester Caldwell");
       Data.put("Cecila Cribb", "Shelli Scheuerman, Santo Schmidt, Nakita Newport, Chester Caldwell, Enriqueta Ealy, Wilfred Weinberger, Arlinda Alarcon, Renea Rausch, Duane Darrell");
       Data.put("Sang Sirois", "Rebekah Regnier, Nakita Newport, Livia Luse, Alfonso Allred, Zada Zynda, Cora Carruth, Ozell Ostrem, Rossana Rackers, Sonny Stratford");
       Data.put("Olinda Oakley", "Judith Juntunen, Emmett Estepp, Arlinda Alarcon, Alfonso Allred, Hollis Hohlt, Lucas Lucht, Lavonna Latson, Olive Osgood, Eva Epping");
       String[] Choose = body.split(",");
       for(int i = Choose.length; i >= 0; i--) {
    	   if(Winner.contains(Choose[i])) {
    		   for(int j = 0; j < Choose.length; j++) {
    			   if(Winner.contains(Choose[j])) {
    				   if(Data.getString(Choose[i]).contains(Choose[j])) {
    					   String tmp = Choose[j];
        				   Choose[j] = Choose[i];
        				   Choose[i] = tmp;
        				   break;
    				   }
    			   }else {
    				   String tmp = Choose[j];
    				   Choose[j] = Choose[i];
    				   Choose[i] = tmp;
    				   break;
    			   }
    		   }
    	   }
       }
       String ans = "";
       for(String i: Choose) {
    	   ans += i + ",";
       }
       ans = ans.substring(0, ans.length()-1);
       return ans;
    }
}
