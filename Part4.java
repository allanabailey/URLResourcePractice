package StringsClass1;
import edu.duke.*;


/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public StorageResource findWebLinks(String url, String searchString) {
        URLResource ur = new URLResource(url);
        StorageResource myList = new StorageResource();
        for(String word : ur.words()) {
                String ytLink = word.toLowerCase();
                int pos = word.toLowerCase().indexOf(searchString.toLowerCase());
                if(pos != -1) {
                    int startIndex = word.lastIndexOf("\"", pos);
                    int stopIndex = word.indexOf("\"", startIndex+1); 
                    ytLink = word.substring(startIndex+1, stopIndex);
                    System.out.println(ytLink);
                    myList.add(ytLink);  
                }
        }
        return myList;
    }
    
    public void testFindLinks(){
        String url = "https://www.dukelearntoprogram.com/course2/data/manylinks.html";
        StorageResource linkList = findWebLinks(url, "YouTube");
        int count = 0;
        for (String myLink : linkList.data()) {
            System.out.println(myLink);
            count ++;
        }
        System.out.println("We found " + count + " YouTube links.");
    }
}
