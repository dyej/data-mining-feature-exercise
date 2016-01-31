public class PreProcess {


	
	public static void main(String[] args) {
		String[] fileList = {"reut2-000.sqm","reut2-001.sqm","reut2-002.sqm","reut2-003.sqm","reut2-004.sqm","reut2-005.sqm"
				,"reut2-006.sqm","reut2-007.sqm","reut2-008.sqm","reut2-009.sqm","reut2-010.sqm","reut2-011.sqm","reut2-012.sqm","reut2-013.sqm"
				,"reut2-014.sqm","reut2-015.sqm", "reut2-016.sqm","reut2-017.sqm","reut2-018.sqm","reut2-019.sqm","reut2-020.sqm","reut2-021.sqm"};
		//do this for each sgm file
		SmellyParser.parseFile("reut2-000.sgm");
		
	}

}