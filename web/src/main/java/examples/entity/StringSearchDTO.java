package examples.entity;

public class StringSearchDTO {

    public StringSearchDTO(String searchString) {
        this.searchString = searchString;
    }

    private String searchString;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
