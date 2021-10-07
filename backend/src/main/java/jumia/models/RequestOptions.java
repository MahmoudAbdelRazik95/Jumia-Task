package jumia.models;

import java.io.Serializable;

public class RequestOptions implements Serializable {

    private int pageNumber;
    private int pageSize;
    private String country;
    private String state;

    public RequestOptions() {
    }

    public RequestOptions(int pageNumber, int pageSize, String country, String state) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.country = country;
        this.state = state;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getCountry() {
        return country;
    }

    public String getState() { return state; }

}
