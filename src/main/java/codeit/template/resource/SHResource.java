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
public class SHResource {
    Logger logger = LoggerFactory.getLogger(SHResource.class);

   @RequestMapping(value = "stock-hunter",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LinkedHashMap<String, Object>[] calculate(@RequestBody String body){
	   JSONArray obj = new JSONArray(body);
	   LinkedHashMap<String, Object>[] ans = new LinkedHashMap[obj.length()];
	   int cout = 0;
	   for(Object i:obj) {
		   JSONObject Here = new JSONObject(i.toString());
		   JSONObject tmp = new JSONObject(Here.get("entryPoint").toString());
		   int start_X = tmp.getInt("first");
		   int start_Y = tmp.getInt("second");
		   
		   tmp = new JSONObject(Here.get("targetPoint").toString());
		   int end_X = tmp.getInt("first");
		   int end_Y = tmp.getInt("second");
		   
		   String[][] Grid = new String[end_Y+1][end_X+1];
		   int[][] riskI_all = new int[end_Y+1][end_X+1];
		   int[][] riskL_all = new int[end_Y+1][end_X+1];
		   for(int y = 0; y <= end_Y; y++) {
			   for(int x = 0; x <= end_X; x++) {
				   int riskI;
				   if(x == 0 & y == 0) {
					   riskI = 0;
				   }else if(x == end_X & y == end_Y) {
					   riskI = 0;
				   }else if(x == 0) {
					   riskI = y*Here.getInt("verticalStepper");
				   }else if(y == 0) {
					   riskI = x*Here.getInt("horizontalStepper");
				   }else {
					   riskI = riskL_all[y][x-1] * riskL_all[y-1][x];
				   }
				   riskI_all[y][x] = riskI;
				   int riskL = (riskI + Here.getInt("gridDepth"))% Here.getInt("gridKey");
				   riskL_all[y][x] = riskL;
				   int riskC = riskL % 3;
				   if(riskC == 0) {
					   Grid[y][x] = "L";
				   }else if(riskC == 1) {
					   Grid[y][x] = "M";
				   }else if(riskC == 2) {
					   Grid[y][x] = "S";
				   }
			   }
		   }
		   LinkedHashMap<String, Object> answer = new LinkedHashMap();
		   answer.put("gridMap", Grid);
		   answer.put("minimumCos", false);
		   ans[cout] = answer;
		   cout += 1;
	   }
       return ans;
       
    }
}
