import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmellyParser {
	
	public static void parseFile(String filename){
		List<String> topics = new ArrayList<String>();
		List<String> places = new ArrayList<String>();
		String body = "";
		File file  = new File(filename);
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			    String line;
			    Boolean inBody = false;
			    while((line = br.readLine()) != null) {
			    	if(line.indexOf("</BODY>")>= 0 && line.indexOf("<BODY>")>= 0){
			    		body = line.substring(line.indexOf("<BODY>")+6, line.indexOf("</BODY>"));
			    		FeatureVectorType1 fVector = new FeatureVectorType1(topics,places,body);
			    		FeatureVectorType2 fVector2 = new FeatureVectorType2(topics,places,body);
		    			PreProcess.articles.add(fVector2);
		    			
		    			fVector.printRefinedData();
		    			body = "";
			    	}
			    	if(inBody == true){
			    		if(line.indexOf("</BODY>") >= 0){
			    			body = body + " " + line.substring(0,line.indexOf("</BODY>"));
			    			inBody = false;
			    			FeatureVectorType1 fVector = new FeatureVectorType1(topics,places,body);
			    			PreProcess.count = PreProcess.count +1;
			    			FeatureVectorType2 fVector2 = new FeatureVectorType2(topics,places,body);
			    			PreProcess.articles.add(fVector2);
			    			
			    			fVector.printRefinedData();
			    			body = "";
			    			
			    		}
			    		else{
			    		body = body + " " +line;
			    		}
			    	}
			    	
			    	else if(line.indexOf("<TOPICS>") >= 0){
			    	 topics = getClassLabel(line,"topics");
			    	 PreProcess.topicsCount = PreProcess.topicsCount +1;
			    	  
			      }
			      else if(line.indexOf("<PLACES>") >= 0){
			    	  places = getClassLabel(line,"places");
			    	  PreProcess.placesCount = PreProcess.placesCount + 1;
			    	  
			    	  
			      }
			      else if(line.indexOf("<BODY>") >= 0){
			    	  inBody = true;
			    	  PreProcess.bodyCount = PreProcess.bodyCount+1;
			    	  body = body + line.substring(line.indexOf("<BODY>")+6, line.length());
			    	  
			    	   }
			    
			    }
			}
			
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<String> getClassLabel(String label, String type){
		if(type == "topics"){
			
			  label = label.substring(label.indexOf("<TOPICS>") + 8, label.indexOf("</TOPICS"));
			  
			  if(label.length() < 1){return null;}
	    	  label = label.replaceAll("<D>", ",");
	    	  label = label.substring(1,label.length());
	    	  label =  label.replaceAll("</D>", "");
	    	  List<String> topics =  Arrays.asList(label.split("\\s*,\\s*"));
	    	  return topics;
		}
		else if(type == "places"){
			 label = label.substring(label.indexOf("<PLACES>") + 8, label.indexOf("</PLACES>"));
			 if(label.length() < 1){return null;}
	    	  label = label.replaceAll("<D>", ",");
	    	  label = label.substring(1,label.length());
	    	  label =  label.replaceAll("</D>", "");
	    	  List<String> places =  Arrays.asList(label.split("\\s*,\\s*"));
	    	  return places;
			
	    	 
	    	  }
		else{
			return null;
		}
	}
}
