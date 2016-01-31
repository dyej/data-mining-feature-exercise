import java.util.ArrayList;

public class PreProcess {

	static ArrayList<FeatureVectorType2> articles = new ArrayList<FeatureVectorType2>();
	static int count = 0;

	
	public static void main(String[] args) {
		String[] fileList = {"reut2-000.sgm","reut2-001.sgm","reut2-002.sgm","reut2-003.sgm","reut2-004.sgm","reut2-005.sgm"
				,"reut2-006.sgm","reut2-007.sgm","reut2-008.sgm","reut2-009.sgm","reut2-010.sgm","reut2-011.sgm","reut2-012.sgm","reut2-013.sgm"
				,"reut2-014.sgm","reut2-015.sgm", "reut2-016.sgm","reut2-017.sgm","reut2-018.sgm","reut2-019.sgm","reut2-020.sgm","reut2-021.sgm"};
		
		for(int i = 0;i<=fileList.length-1;i++){
		SmellyParser.parseFile(fileList[i]);
		}
		//TODO print results for each featurevetortype2 in articles
		System.out.println(count);
	}

}