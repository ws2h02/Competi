package codeit.template.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParasiteResource {
    Logger logger = LoggerFactory.getLogger(ParasiteResource.class);

   @RequestMapping(value = "parasite",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object>[] calculate(@RequestBody Object[] body){
	   LinkedHashMap<String, Object>[] ans = new LinkedHashMap[body.length];
	   LinkedHashMap<String, Object> object = new LinkedHashMap();
	   int cont = 0;
	   for(Object i : body) {
		   String Data = i.toString();

		   String room = "";
		   int temp_1 = 5;
		   int temp_2 = Data.indexOf("room");
		   while(Data.charAt(temp_1 + temp_2) != ',') {
			   room += Data.charAt(temp_1 + temp_2) ;
			   temp_2 += 1;
		   }

		   
		   String InI = "";
		   temp_1 = 22;
		   temp_2 = Data.indexOf("interestedIndividuals");
		   while(Data.charAt(temp_1 + temp_2) != '}') {
			   InI += Data.charAt(temp_1 + temp_2) ;
			   temp_2 += 1;
		   }
		   InI = InI.replace(" ", "");
		   InI = InI.replace("[", "");
		   InI = InI.replace("]", "");
		   String[] items = InI.split(",");
		   int[] InIds = new int[items.length];
		   for(int v = 0; v < items.length; v++) {
			   InIds[v] = Integer.parseInt(items[v]);
		   }
		   for(int v : InIds) {
			   System.out.println(v);
		   }
		   
		   
		   String Grid = "";
		   temp_1 = 5;
		   temp_2 = Data.indexOf("grid");
		   int opened = 0;
		   if(Data.charAt(temp_1 + temp_2) == '[') {
			   opened += 1;
		   }
		   while(opened != 0) {
			   Grid += Data.charAt(temp_1 + temp_2) ;
			   temp_2 += 1;
			   if(Data.charAt(temp_1 + temp_2) == '[') {
				   opened += 1;
			   }
			   if(Data.charAt(temp_1 + temp_2) == ']') {
				   opened -= 1;
			   }
		   }
		   Grid += ']';
		   int G_col;
		   Grid = Grid.replace("[","");
		   Grid=Grid.substring(0,Grid.length()-1);
		   String s1[] = Grid.split("],");
		   G_col = s1.length;
		   Grid = Grid.replace("]","");
		   Grid = Grid.replace(",","");
		   Grid = Grid.replace(" ","");
		   int G_row = Grid.length()/G_col;
		   System.out.println("Row: "+ G_row);
		   System.out.println("Col: "+ G_col);
		   
		   int time = 0;
		   int basic = 3;
		   char[] temp = Grid.toCharArray();
		   ArrayList<Integer> Grid_p1 = new ArrayList<Integer>();
		   for(int a = 0; a < temp.length; a++) {
			   Grid_p1.add((int)temp[a] - 48);
		   }
		   ArrayList<Integer> Grid_p3 = new ArrayList<Integer>(Grid_p1);
		   
		   while(Grid_p1.contains(time + basic)) {
			   while(Grid_p1.contains(time + basic)) {
				   int posi = Grid_p1.indexOf(time + basic);

				   Grid_p1.set(posi, (time + basic)*-1);
				   if(posi < G_row) {
					   if(posi == 0) {
						   if(Grid_p1.get(posi+1) == 1) {
							   Grid_p1.set(posi+1,time + basic+1);

						   }
						   if(Grid_p1.get(posi+G_row) == 1) {
							   Grid_p1.set(posi+G_row,time + basic+1);
							
						   }
					   }else if(posi == G_row-1) {
						   if(Grid_p1.get(posi-1) == 1) {
							   Grid_p1.set(posi-1,time + basic+1);
				
						   }
						   if(posi+G_row >= Grid_p1.size()) {
							   break;
						   }
						   if(Grid_p1.get(posi+G_row) == 1) {
							   Grid_p1.set(posi+G_row,time + basic+1);
			
						   }
					   }else {
						   if(Grid_p1.get(posi+1) == 1) {
							   Grid_p1.set(posi+1,time + basic+1);
		
						   }
						   if(Grid_p1.get(posi-1) == 1) {
							   Grid_p1.set(posi-1,time + basic+1);

						   }
						   if(Grid_p1.get(posi+G_row) == 1) {
		
							   Grid_p1.set(posi+G_row,time + basic+1);
	
						   }
					   }
				   }else if(posi >= G_row*(G_col-1)) {
					   if(posi == G_row*(G_col-1)) {
						   if(Grid_p1.get(posi+1) == 1) {
							   Grid_p1.set(posi+1,time + basic+1);
		
						   }
						   if(Grid_p1.get(posi-G_row) == 1) {
							   Grid_p1.set(posi-G_row,time + basic+1);

						   }
					   }else if(posi == Grid_p1.size()-1) {
						   if(Grid_p1.get(posi-1) == 1) {
							   Grid_p1.set(posi-1,time + basic+1);

						   }
						   if(Grid_p1.get(posi-G_row) == 1) {
							   Grid_p1.set(posi-G_row,time + basic+1);

						   }
					   }else {
						   if(Grid_p1.get(posi+1) == 1) {
							   Grid_p1.set(posi+1,time + basic+1);

						   }
						   if(Grid_p1.get(posi-1) == 1) {
							   Grid_p1.set(posi-1,time + basic+1);

						   }
						   if(Grid_p1.get(posi-G_row) == 1) {
							   Grid_p1.set(posi-G_row,time + basic+1);

						   }
					   }
				   }else if(posi % G_row == 0) {
					   if(Grid_p1.get(posi+1) == 1) {
						   Grid_p1.set(posi+1,time + basic+1);

					   }
					   if(Grid_p1.get(posi+G_row) == 1) {
						   Grid_p1.set(posi+G_row,time + basic+1);

					   }
					   if(Grid_p1.get(posi-G_row) == 1) {
						   Grid_p1.set(posi-G_row,time + basic+1);

					   }
				   }else if((posi+1) % G_row == 0) {
					   if(Grid_p1.get(posi-1) == 1) {
						   Grid_p1.set(posi-1,time + basic+1);

					   }
					   if(Grid_p1.get(posi+G_row) == 1) {
						   Grid_p1.set(posi+G_row,time + basic+1);

					   }
					   if(Grid_p1.get(posi-G_row) == 1) {
						   Grid_p1.set(posi-G_row,time + basic+1);

					   }
				   }else {
					   if(Grid_p1.get(posi+1) == 1) {
						   Grid_p1.set(posi+1,time + basic+1);

					   }
					   if(Grid_p1.get(posi-1) == 1) {
						   Grid_p1.set(posi-1,time + basic+1);

					   }
					   if(Grid_p1.get(posi+G_row) == 1) {
						   Grid_p1.set(posi+G_row,time + basic+1);

					   }
					   if(Grid_p1.get(posi-G_row) == 1) {
						   Grid_p1.set(posi-G_row,time + basic+1);

					   }
				   }
				   
			   }
			   time += 1;
		   }
		   
		   time = 0;
		   while(Grid_p3.contains(time + basic)) {
			   while(Grid_p3.contains(time + basic)) {
				   
				   int posi = Grid_p3.indexOf(time + basic);
				   Grid_p3.set(posi, (time + basic)*-1);
				   if(posi < G_row) {
					   if(posi == 0) {
						   if(Grid_p3.get(posi+1) == 1) {
							   Grid_p3.set(posi+1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi+G_row) == 1) {
							   Grid_p3.set(posi+G_row,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi+G_row+1) == 1) {
							   Grid_p3.set(posi+G_row+1,time + basic+1);
							   
						   }
					   }else if(posi == G_row-1) {
						   if(Grid_p3.get(posi-1) == 1) {
							   Grid_p3.set(posi-1,time + basic+1);
							   
						   }
						   if(posi+G_row >= Grid_p3.size()) {
							   break;
						   }
						   if(Grid_p3.get(posi+G_row) == 1) {
							   Grid_p3.set(posi+G_row,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi+G_row-1) == 1) {
							   Grid_p3.set(posi+G_row-1,time + basic+1);
							   
						   }
					   }else {
						   if(Grid_p3.get(posi+1) == 1) {
							   Grid_p3.set(posi+1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-1) == 1) {
							   Grid_p3.set(posi-1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi+G_row) == 1) {
							   System.out.println("testing");
							   Grid_p3.set(posi+G_row,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi+G_row+1) == 1) {
							   Grid_p3.set(posi+G_row+1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi+G_row-1) == 1) {
							   Grid_p3.set(posi+G_row-1,time + basic+1);
							   
						   }
					   }
				   }else if(posi >= G_row*(G_col-1)) {
					   if(posi == G_row*(G_col-1)) {
						   if(Grid_p3.get(posi+1) == 1) {
							   Grid_p3.set(posi+1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row) == 1) {
							   Grid_p3.set(posi-G_row,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row+1) == 1) {
							   Grid_p3.set(posi-G_row+1,time + basic+1);
							   
						   }
					   }else if(posi == Grid_p3.size()-1) {
						   if(Grid_p3.get(posi-1) == 1) {
							   Grid_p3.set(posi-1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row) == 1) {
							   Grid_p3.set(posi-G_row,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row-1) == 1) {
							   Grid_p3.set(posi-G_row-1,time + basic+1);
							   
						   }
					   }else {
						   if(Grid_p3.get(posi+1) == 1) {
							   Grid_p3.set(posi+1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-1) == 1) {
							   Grid_p3.set(posi-1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row) == 1) {
							   Grid_p3.set(posi-G_row,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row+1) == 1) {
							   Grid_p3.set(posi-G_row+1,time + basic+1);
							   
						   }
						   if(Grid_p3.get(posi-G_row-1) == 1) {
							   Grid_p3.set(posi-G_row-1,time + basic+1);
							   
						   }
					   }
				   }else if(posi % G_row == 0) {
					   if(Grid_p3.get(posi+1) == 1) {
						   Grid_p3.set(posi+1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi+G_row) == 1) {
						   Grid_p3.set(posi+G_row,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-G_row) == 1) {
						   Grid_p3.set(posi-G_row,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-G_row+1) == 1) {
						   Grid_p3.set(posi-G_row+1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi+G_row+1) == 1) {
						   Grid_p3.set(posi+G_row+1,time + basic+1);
						   
					   }
				   }else if((posi+1) % G_row == 0) {
					   if(Grid_p3.get(posi-1) == 1) {
						   Grid_p3.set(posi-1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi+G_row) == 1) {
						   Grid_p3.set(posi+G_row,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-G_row) == 1) {
						   Grid_p3.set(posi-G_row,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-G_row-1) == 1) {
						   Grid_p3.set(posi-G_row-1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi+G_row-1) == 1) {
						   Grid_p3.set(posi+G_row-1,time + basic+1);
						   
					   }
				   }else {
					   if(Grid_p3.get(posi+1) == 1) {
						   Grid_p3.set(posi+1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-1) == 1) {
						   Grid_p3.set(posi-1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi+G_row) == 1) {
						   Grid_p3.set(posi+G_row,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-G_row) == 1) {
						   Grid_p3.set(posi-G_row,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi-G_row+1) == 1) {
						   Grid_p3.set(posi-G_row+1,time + basic+1);
						   
					   }
					   if(Grid_p3.get(posi+G_row+1) == 1) {
						   Grid_p3.set(posi+G_row+1,time + basic+1);
					   }
					   if(Grid_p3.get(posi-G_row-1) == 1) {
						   Grid_p3.set(posi-G_row-1,time + basic+1);
					   }
					   if(Grid_p3.get(posi+G_row-1) == 1) {
						   Grid_p3.set(posi+G_row-1,time + basic+1);
					   }
				   }
				   
			   }
			   time += 1;
		   }
		   
		   int energy = 0;
		   ArrayList<Integer> Grid_p4 = new ArrayList<Integer>(Grid_p1);
		   int n = Grid_p4.size();
		   for(int b = 1; b < n; b++) {
			   if(Grid_p4.get(b) <= -3) {
				   Grid_p4.set(b, 4);
			   }
		   }
		   for(int b = 0; b < n; b++) {
			   if (Grid_p4.get(b) == 1) {
				   if(b%G_row+2 < G_row) {
					   if(Grid_p4.get(b+2) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b%G_row-2 >= 0) {
					   if(Grid_p4.get(b-2) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b+G_row+G_row < n) {
					   if(Grid_p4.get(b+G_row+G_row) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b-G_row-G_row >= 0) {
					   if(Grid_p4.get(b-G_row-G_row) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b-G_row >= 0 & b%G_row+1 < G_row) {
					   if(Grid_p4.get(b-G_row+1) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b+G_row < n & b%G_row+1 < G_row) {
					   if(Grid_p4.get(b+G_row+1) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b-G_row >= 0 & b%G_row-1 >= 0) {
					   if(Grid_p4.get(b-G_row-1) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
				   if(b+G_row < n & b%G_row-1 >= 0) {
					   if(Grid_p4.get(b+G_row-1) == 4) {
						   Grid_p4.set(b,3);
						   energy += 1;
					   }
				   }
			   }
		   }
		   while(Grid_p4.contains(3)) {
			   while(Grid_p4.contains(3)) {
				   int posi = Grid_p4.indexOf(3);
				   Grid_p4.set(posi, 4);
				   if(posi < G_row) {
					   if(posi == 0) {
						   if(Grid_p4.get(posi+1) == 1) {
							   Grid_p4.set(posi+1,4);

						   }
						   if(Grid_p4.get(posi+G_row) == 1) {
							   Grid_p4.set(posi+G_row,4);
							
						   }
					   }else if(posi == G_row-1) {
						   if(Grid_p4.get(posi-1) == 1) {
							   Grid_p4.set(posi-1,4);
				
						   }
						   if(posi+G_row >= Grid_p4.size()) {
							   break;
						   }
						   if(Grid_p4.get(posi+G_row) == 1) {
							   Grid_p4.set(posi+G_row,4);

						   }
					   }else {
						   if(Grid_p4.get(posi+1) == 1) {
							   Grid_p4.set(posi+1,4);
		
						   }
						   if(Grid_p4.get(posi-1) == 1) {
							   Grid_p4.set(posi-1,4);

						   }

						   if(Grid_p4.get(posi+G_row) == 1) {
		
							   Grid_p4.set(posi+G_row,4);
	
						   }

					   }
				   }else if(posi >= G_row*(G_col-1)) {
					   if(posi == G_row*(G_col-1)) {
						   if(Grid_p4.get(posi+1) == 1) {
							   Grid_p4.set(posi+1,4);
		
						   }

						   if(Grid_p4.get(posi-G_row) == 1) {
							   Grid_p4.set(posi-G_row,4);

						   }
					   }else if(posi == Grid_p4.size()-1) {
						   if(Grid_p4.get(posi-1) == 1) {
							   Grid_p4.set(posi-1,4);

						   }
						   if(Grid_p4.get(posi-G_row) == 1) {
							   Grid_p4.set(posi-G_row,4);

						   }
					   }else {
						   if(Grid_p4.get(posi+1) == 1) {
							   Grid_p4.set(posi+1,4);

						   }
						   if(Grid_p4.get(posi-1) == 1) {
							   Grid_p4.set(posi-1,4);

						   }
						   if(Grid_p4.get(posi-G_row) == 1) {
							   Grid_p4.set(posi-G_row,4);

						   }
					   }
				   }else if(posi % G_row == 0) {
					   if(Grid_p4.get(posi+1) == 1) {
						   Grid_p4.set(posi+1,4);

					   }
					   if(Grid_p4.get(posi+G_row) == 1) {
						   Grid_p4.set(posi+G_row,4);

					   }
					   if(Grid_p4.get(posi-G_row) == 1) {
						   Grid_p4.set(posi-G_row,4);

					   }
				   }else if((posi+1) % G_row == 0) {
					   if(Grid_p4.get(posi-1) == 1) {
						   Grid_p4.set(posi-1,4);

					   }
					   if(Grid_p4.get(posi+G_row) == 1) {
						   Grid_p4.set(posi+G_row,4);

					   }
					   if(Grid_p4.get(posi-G_row) == 1) {
						   Grid_p4.set(posi-G_row,4);

					   }
				   }else {
					   if(Grid_p4.get(posi+1) == 1) {
						   Grid_p4.set(posi+1,4);

					   }
					   if(Grid_p4.get(posi-1) == 1) {
						   Grid_p4.set(posi-1,4);

					   }
					   if(Grid_p4.get(posi+G_row) == 1) {
						   Grid_p4.set(posi+G_row,4);

					   }
					   if(Grid_p4.get(posi-G_row) == 1) {
						   Grid_p4.set(posi-G_row,4);

					   }
				   }
			   }
			   for(int b = 0; b < n; b++) {
				   if (Grid_p4.get(b) == 1) {
					   if(b%G_row+2 < G_row) {
						   if(Grid_p4.get(b+2) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b%G_row-2 >= 0) {
						   if(Grid_p4.get(b-2) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b+G_row+G_row < n) {
						   if(Grid_p4.get(b+G_row+G_row) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b-G_row-G_row >= 0) {
						   if(Grid_p4.get(b-G_row-G_row) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b-G_row >= 0 & b%G_row+1 < G_row) {
						   if(Grid_p4.get(b-G_row+1) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b+G_row < n & b%G_row+1 < G_row) {
						   if(Grid_p4.get(b+G_row+1) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b-G_row >= 0 & b%G_row-1 >= 0) {
						   if(Grid_p4.get(b-G_row-1) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
					   if(b+G_row < n & b%G_row-1 >= 0) {
						   if(Grid_p4.get(b+G_row-1) == 4) {
							   Grid_p4.set(b,3);
							   energy += 1;
						   }
					   }
				   }
			   }
		   }
		   
		   LinkedHashMap<String, Object> p1_map = new LinkedHashMap<String, Object>();
		   
		   for(int num = 0; num < InIds.length; num+=2) {
			   String p1 = "";
			   System.out.println("A: " + InIds[num]);
			   System.out.println("B: " + InIds[num+1]);
			   int Inpo = InIds[num]*G_row+InIds[num+1];
			   p1 += InIds[num] + "," + InIds[num+1];
			   if(Grid_p1.get(Inpo) == 1 |Grid_p1.get(Inpo) == 2 |Grid_p1.get(Inpo) == 0| Grid_p1.get(Inpo) == -3) {
				   p1_map.put(p1, -1);
			   }else {
				   p1_map.put(p1, -1*Grid_p1.get(Inpo)-3);
			   }
		   }
		   int p2;
		   if(Grid_p1.contains(1)) {
			   p2 = -1;
		   }else {
			   p2 = -3;
			   for (int b = 0; b < n; b++) {
		            if (Grid_p1.get(b) < p2) {
		                p2 = Grid_p1.get(b);
		            }
		       }
			   p2 = -1*p2-3;
		   }
		   
		   int p3;
		   if(Grid_p3.contains(1)) {
			   p3 = -1;
		   }else {
			   p3 = -3;
			   for (int b = 0; b < n; b++) {
		            if (Grid_p3.get(b) < p3) {
		                p3 = Grid_p3.get(b);
		            }
		       }
			   p3 = -1*p3-3;
		   }
		   
		   object.put("room", Integer.parseInt(room));
		   object.put("p1",p1_map);
		   object.put("p2",p2);
		   object.put("p3",p3);
		   if(Grid_p4.contains(1)) {
			   object.put("p4", -1);
		   }else {
			   object.put("p4", energy);
		   }
		   
		   ans[cont] = new LinkedHashMap<String, Object>(object);
		   cont += 1;
	   }
	   
	   
	   return ans;
       
    }	
}

