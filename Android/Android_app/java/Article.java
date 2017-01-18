/**
 * Created by Adeline Léger et François Piat on 07/12/2016.
 */

public class Article {
    /**
     * This class define all of the articles element. That contains reading accessor and writing accessor
     *
     */
    private String author = null, title = null, journal=null, year=null, volume=null, number=null, pages=null,
            month=null, doi=null, url=null, keywords=null, abstracts=null, pdf=null;
    private String[] tags;
    private int id;

    public Article(){}

    public void setId(int id){this.id = id;}// add the id of the article
    public void setAuthor(String author) {this.author = author;}	// add author
    public void setTitle(String title) {this.title = title;}						//add title
    public void setJournal(String journal) {this.journal = journal;}					//add paper
    public void setYear(String year) {this.year = year;}						// add publication year
    public void setVolume(String volume) {	this.volume = volume;}	// add the volume
    public void setNumber(String number) {	 this.number = number;}	// add number
    public void setPages(String pages) {this.pages = pages;}							// add month of publication
    public void setMonth(String month) {this.month = month;}							// add month of publication
    public void setDoi(String doi) { this.doi = doi;}				// add id of the article
    public void setUrl(String url) {this.url = url;}				// add URL to access to the code
    public void setKeywords(String keywords) {this.keywords = keywords;}		// add key words define in the BibTex file
    public void setAbstracts(String abstracts) {this.abstracts = abstracts;}						// add Abstracts of the text
    public void setPdf(String pdf) {this.pdf = pdf;}				//  add link to access to the pdf ressource
    public void setTags(String[] tags, int id) {
        this.tags = tags;
    }		// add user's tag
    public void setArticle(String[] info){
        /** Create an article
         * @param info
         * 		all the information from a bibtex
         */
        setAuthor(info[0]);
        setTitle(info[1]);
        setJournal(info[2]);
        setYear(info[3]);
        setVolume(info[4]);
        setNumber(info[5]);
        setPages(info[6]);
        setMonth(info[7]);
        setDoi(info[8]);
        setUrl(info[9]);
        setKeywords(info[10]);
        setAbstracts(info[11]);
    }
    // Reading Accessor
    public int getId(){return id;}
    public String getAuthor(){return author;}					// Return the author
    public String getTitle(){return title;}					// Return the title
    public String getJournal(){return journal;}					// Return the publication paper
    public String getYear(){return year;}					// Return the year of publication
    public String getVolume(){return volume;}					// Return the volume
    public String getNumber(){return number;}					// Return the number
    public String getPages(){return pages;}					// Return the pages
    public String getMonth(){return month;}						// Return the month of publication
    public String getDoi(){return doi;}						// Return id of article
    public String getUrl(){return url;}						// Return URL
    public String getKeywords(){return keywords;}					// Rreturn the keywords
    public String getAbstracts(){ return abstracts;}					// Return a Abstracts ofth article
    public String getPdf(){return pdf;}
    public String[] getTag(){
        String[] tags=this.tags;
        return tags;
    }					// Return the keywords

}
