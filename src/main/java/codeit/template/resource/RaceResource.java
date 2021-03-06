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
       String Winner = "Mari Maus,Olive Osgood,Rossana Rackers,Cecila Cribb,Sang Sirois,Olinda Oakley,Rebekah Regnier,Shelli Scheuerman,Judi Jacquez,Emily Eckles,Gaston Glotfelty,Stepanie Strang,Alayna Alberson,Annamarie Ahern";
       Data.put("Mari Maus", "Caitlin Cully, Charita Collett, Franklin Filippi, Jared Jinkins, Fletcher Felty, Candice Cahill, Francisco Finchum, Tracie Temblador, Leslie Lubinsky");
       Data.put("Olive Osgood", "Astrid Acheson, Candice Cahill, Vanda Vonderheide, Boris Batts, Josiah Jarnagin, Sharyl Shepler, Jewel Jaeger, Colin Crail, Reed Rotolo");
       Data.put("Rossana Rackers", "Zada Zynda, Josiah Jarnagin, Shawn Setliff, Sixta Sulton, Colin Crail, Lemuel Lorenzo, Rebekah Regnier, Duane Darrell, Chester Caldwell, Olinda Oakley, Lucas Lucht, Lauretta Lippard, Hollis Hohlt, Cecila Cribb, Corine Cottrill, Warren Wesolowski, Joseph Jarosz, Cora Carruth");
       Data.put("Cecila Cribb", "Shelli Scheuerman, Santo Schmidt, Nakita Newport, Chester Caldwell, Enriqueta Ealy, Wilfred Weinberger, Arlinda Alarcon, Renea Rausch, Duane Darrell");
       Data.put("Sang Sirois", "Rebekah Regnier, Nakita Newport, Livia Luse, Alfonso Allred, Zada Zynda, Cora Carruth, Ozell Ostrem, Rossana Rackers, Sonny Stratford, Warren Wesolowski, Judith Juntunen, Fletcher Felty, Sonny Stratford, Rudolf Ravelo, Annalee Angert, Kelsi Kraker, Renea Rausch, Evelyn Eckstein, Duane Darrell, Annalee Angert, Rebekah Regnier, Fletcher Felty, Evelyn Eckstein, Armida Abarca, Randy Rohlfing, Enriqueta Ealy, Rossana Rackers");
       Data.put("Olinda Oakley", "Judith Juntunen, Emmett Estepp, Arlinda Alarcon, Alfonso Allred, Hollis Hohlt, Lucas Lucht, Lavonna Latson, Olive Osgood, Eva Epping");
       Data.put("Rebekah Regnier", "Duane Darrell, Rudolf Ravelo, Santo Schmidt, Arron Ammerman, Adaline Anwar, Francisco Finchum, Pamula Parrinello, Josiah Jarnagin, Randy Rohlfing");
       Data.put("Judi Jacquez", "Carlo Chute, Karin Kurth, Arron Ammerman, Synthia Sylvestre, Lorita Loeffler, Erwin Ewen, Danae Depuy, Vida Veal, Regenia Rathburn, Stepanie Strang, Yu Yeates, Lester Larin, Marcellus Mallow, Valerie Vera, Sacha Stanforth, Alanna Ayoub, Fabian Fogel, Derek Duclos");
       Data.put("Emily Eckles","Lamont Lasch, Adina Able, Robbyn Ryland, Dorathy Detweiler, Lyman Laseter, Bernie Bondy, Ozell Ostrem, Fabian Fogel, Derek Duclos,Judith Juntunen, Terry Tietz, Valerie Vera, Alex Appleton, Duane Darrell, Brady Borda, Bernie Bondy, Darren Dudley, Dominque Deshon,Yuette Yurick, Justa Jeffery, Derek Duclos, Alayna Alberson, Livia Luse, Yu Yeates, Robbyn Ryland, Amos Alward, Shirly Sosebee, Gary Ginsburg, Derek Duclos, Alayna Alberson, Dominque Deshon, Livia Luse, Stepanie Strang, Arron Ammerman, Carlo Chute, Gaston Glotfelty, Gaston Glotfelty, Eva Epping, Vida Veal, Derek Duclos, Bernadine Brackin, Armida Abarca, Valerie Vera, Annalee Angert, Arron Ammerman, Cecila Cribb");
       Data.put("Gaston Glotfelty", "Fletcher Felty, Yuette Yurick, Willian Wahlen, Trinity Trueblood, Thanh Tammaro, Vida Veal, Livia Luse, Franklin Filippi, Danae Depuy, Rebekah Regnier, Cecila Cribb, Stepanie Strang, Gaston Glotfelty, Judi Jacquez, Winfred Wilton, Lavonna Latson, Kali Krupp, Vida Veal, Chantel Corn");
       Data.put("Shelli Scheuerman", "Judith Juntunen, Boris Batts, Livia Luse, Duane Darrell, Jefferson Juhl, Pamula Parrinello, Lauretta Lippard, Lamont Lasch, Gary Ginsburg");
       Data.put("Stepanie Strang", "Alaina Adolphson, Douglas Delima, Gary Ginsburg, Boris Batts, Karin Kurth, Farrah Frasure, Carlo Chute, Pamula Parrinello, Danae Depuy, Rebekah Regnier, Anibal Abler, Vida Veal, Arron Ammerman, Danae Depuy, Sonny Stratford, Justin Jack, Franklin Filippi, Lester Larin");
       Data.put("Alayna Alberson", "Darren Dudley, Leslie Lubinsky, Pamula Parrinello, Sonny Stratford, Alayna Alberson, Alanna Ayoub, Regenia Rathburn, Annalee Angert, Lamont Lasch, Yu Yeates");
       Data.put("Annamarie Ahern","Rebekah Regnier, Winfred Wilton, Kali Krupp, Danae Depuy, Anibal Abler, Darren Dudley, Hollis Hohlt, Yuette Yurick, Armida Abarca");
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
