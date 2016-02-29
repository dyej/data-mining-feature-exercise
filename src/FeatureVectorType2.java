import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.AbstractMap;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.util.Random;


public class FeatureVectorType2 {
	List<String> topics = new ArrayList<String>();
	List<String> places = new ArrayList<String>();
	List<String> keyWords = new ArrayList<String>();
	List<String> allWords = new ArrayList<String>();

	public FeatureVectorType2(List<String> topics,List<String> places, String body){
	this.topics = topics;
	this.places = places;
	String filteredBody = body.replaceAll("[0-9]", "");
	filteredBody = filteredBody.toLowerCase();
	String[] words = (filteredBody.split("[[ ]*|[,]*|[\\.]*|[:]*|[>]*|[<]*|[>]*|[/]*|[!]*|[?]*|[+]*|[;]*|[&]*|[(]*|[)]*|[\"]]+"));
	
	Set<String> stopWords = FeatureVectorType1.getStopWords();
	
	for(int i = 0;i<words.length-1;i++){
		if(!stopWords.contains(words[i]) && words[i] != ""){
			
			allWords.add(words[i]);
		}
	} 
	
	
	}
	
	public void getKeyWords(){
		AbstractMap<String, Double> scoreMap = new HashMap<String,Double>();
		Double sum = 0.0;
		HashSet<Integer> randomArticlesIndex = new HashSet<Integer>();
		ArrayList<FeatureVectorType2> randomArticles = new ArrayList<FeatureVectorType2>();
		Random rng = new Random();
		for(int i = 0;i<300;i++){
			randomArticles.add(PreProcess.articles.get(rng.nextInt(19043)));
		}
		
		for(String word: this.allWords){
			double tf = TFIDFCalculator.tf(allWords,word);
			
			double idf = TFIDFCalculator.idf(randomArticles, word);
			
			double score = TFIDFCalculator.tfidf(tf, idf);
			
			sum = sum + score;
			//System.out.println(score);
			scoreMap.put(word,score);
		}
		
		Set<String> keys = scoreMap.keySet();
		for(String key : keys){
			///System.out.println(scoreMap.get(key) > 0.0);
			//System.out.println(key);
		if(scoreMap.get(key) > sum/scoreMap.size()){
			
			keyWords.add(key);
		}
		}
	}
	public void printRefinedData(){
		System.out.println(keyWords);
		File file = new File("FeatureVector#2.csv");
		FileWriter fw;
		try {
			fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(topics + ", " + places + ", " + keyWords);
			
			pw.println();
			pw.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}
	
	
}
