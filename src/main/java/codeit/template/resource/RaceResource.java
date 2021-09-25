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
       String Winner = "Mari Maus,Olive Osgood,Rossana Rackers,Cecila Cribb,Sang Sirois,Olinda Oakley,Rebekah Regnier,Shelli Scheuerman";
       Data.put("Mari Maus", "Caitlin Cully, Charita Collett, Franklin Filippi, Jared Jinkins, Fletcher Felty, Candice Cahill, Francisco Finchum, Tracie Temblador, Leslie Lubinsky");
       Data.put("Olive Osgood", "Astrid Acheson, Candice Cahill, Vanda Vonderheide, Boris Batts, Josiah Jarnagin, Sharyl Shepler, Jewel Jaeger, Colin Crail, Reed Rotolo");
       Data.put("Rossana Rackers", "Zada Zynda, Josiah Jarnagin, Shawn Setliff, Sixta Sulton, Colin Crail, Lemuel Lorenzo, Rebekah Regnier, Duane Darrell, Chester Caldwell, Olinda Oakley, Lucas Lucht, Lauretta Lippard, Hollis Hohlt, Cecila Cribb, Corine Cottrill, Warren Wesolowski, Joseph Jarosz, Cora Carruth");
       Data.put("Cecila Cribb", "Shelli Scheuerman, Santo Schmidt, Nakita Newport, Chester Caldwell, Enriqueta Ealy, Wilfred Weinberger, Arlinda Alarcon, Renea Rausch, Duane Darrell");
       Data.put("Sang Sirois", "Rebekah Regnier, Nakita Newport, Livia Luse, Alfonso Allred, Zada Zynda, Cora Carruth, Ozell Ostrem, Rossana Rackers, Sonny Stratford, Warren Wesolowski, Judith Juntunen, Fletcher Felty, Sonny Stratford, Rudolf Ravelo, Annalee Angert, Kelsi Kraker, Renea Rausch, Evelyn Eckstein, Duane Darrell, Annalee Angert, Rebekah Regnier, Fletcher Felty, Evelyn Eckstein, Armida Abarca, Randy Rohlfing, Enriqueta Ealy, Rossana Rackers");
       Data.put("Olinda Oakley", "Judith Juntunen, Emmett Estepp, Arlinda Alarcon, Alfonso Allred, Hollis Hohlt, Lucas Lucht, Lavonna Latson, Olive Osgood, Eva Epping");
       Data.put("Rebekah Regnier", "Duane Darrell, Rudolf Ravelo, Santo Schmidt, Arron Ammerman, Adaline Anwar, Francisco Finchum, Pamula Parrinello, Josiah Jarnagin, Randy Rohlfing");
       Data.put("Judi Jacquez", "Carlo Chute, Karin Kurth, Arron Ammerman, Synthia Sylvestre, Lorita Loeffler, Erwin Ewen, Danae Depuy, Vida Veal, Regenia Rathburn");
       Data.put("Emily Eckles","Lamont Lasch, Adina Able, Robbyn Ryland, Dorathy Detweiler, Lyman Laseter, Bernie Bondy, Ozell Ostrem, Fabian Fogel, Derek Duclos,Judith Juntunen, Terry Tietz, Valerie Vera, Alex Appleton, Duane Darrell, Brady Borda, Bernie Bondy, Darren Dudley, Dominque Deshon,Yuette Yurick, Justa Jeffery, Derek Duclos, Alayna Alberson, Livia Luse, Yu Yeates, Robbyn Ryland, Amos Alward, Shirly Sosebee, Gary Ginsburg, Derek Duclos, Alayna Alberson, Dominque Deshon, Livia Luse, Stepanie Strang, Arron Ammerman, Carlo Chute, Gaston Glotfelty");
       
       Data.put("Shelli Scheuerman", "Judith Juntunen, Boris Batts, Livia Luse, Duane Darrell, Jefferson Juhl, Pamula Parrinello, Lauretta Lippard, Lamont Lasch, Gary Ginsburg");
       String[] Choose = body.split(",");
       for(int i = Choose.length-1; i > 0;) {
    	   if(Winner.contains(Choose[i])) {
    		   for(int j = 0; j < i;) {
    			   if(Winner.contains(Choose[j])) {
    				   if(Data.getString(Choose[i]).contains(Choose[j])) {
    					   String tmp = Choose[j];
        				   Choose[j] = Choose[i];
        				   Choose[i] = tmp;
        				   continue;
    				   }else {
    					   j++;
    				   }
    			   }else {
    				   String tmp = Choose[j];
    				   Choose[j] = Choose[i];
    				   Choose[i] = tmp;
    				   j++;
    				   break;
    			   }
    		   }
    		   i--;
    	   }else {
    		   i--;
    	   }
    	   for(String z: Choose) {
        	   System.out.print(z);
           }
    	   System.out.println(i);
       }
       String ans = "";
       for(String i: Choose) {
    	   ans += i + ",";
       }
       ans = ans.substring(0, ans.length()-1);
       return ans;
    }
}
