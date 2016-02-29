import java.util.ArrayList;
import java.util.List;

public class TFIDFCalculator {
	
	
	static public double tf(List<String> article, String term){
		int numOfArticles = 19043;
		double result = 0;
		for(String word: article){
			if(term.equals(word)){
				result++;
			}
		}
		return result;
	}
	
	static public double idf(List<FeatureVectorType2> docs, String term){
		double count = 0;
		int numOfArticles = 19043;
		
		
		for(FeatureVectorType2 doc: docs){
		
	
			for(String word : doc.allWords){
				if(term.equals(word)){
					count++;
					break;
				}
			}
			
		}
		if (count == 0) {
			count = 1;
		}
		return Math.log(300/ count);
	}
	static public double tfidf(double tf, double idf){
		
		return tf*idf;
	}
	
}
