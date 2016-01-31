import java.util.List;

public class TFIDFCalculator {
	
	
	public double tf(List<String> article, String term){
		double result = 0;
		for(String word: article){
			if(term.equals(word)){
				result++;
			}
		}
		return result/ article.size();
	}
	
	public double idf(List<FeatureVectorType2> docs, String term){
		double count = 0;
		for(FeatureVectorType2 doc: docs){
			for(String word : doc.keyWords){
				if(term.equals(word)){
					count++;
					break;
				}
			}
			
		}
		return Math.log(21578 / count);
	}
	public double tfidf(double tf, double idf){
		return tf*idf;
	}
	
}
