import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;


public class FeatureVectorType2 {
	List<String> topics = new ArrayList<String>();
	List<String> places = new ArrayList<String>();
	List<String> keyWords = new ArrayList<String>();
	

	public FeatureVectorType2(List<String> topics,List<String> places, String body){
	this.topics = topics;
	this.places = places;
	this.keyWords = getKeyWords(body);
	}
	
	private List<String> getKeyWords(String body){
		List<String> keyWords = new ArrayList<String>();
		body = body.replaceAll("[0-9]", "");
		body = body.toLowerCase();
		String[] words = body.split("[[ ]*|[,]*|[\\.]*|[:]*|[>]*|[<]*|[>]*|[/]*|[!]*|[?]*|[+]*|[;]*|[&]*|[(]*|[)]*|[\"]]+");
		return keyWords;
	}
	
	
}
