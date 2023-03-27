package io.bigtreelab.rndbox.api.paging;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	
	/** 현재 페이지 번호 */
	@ApiModelProperty(required = false, value = "페이지 번호", example = "1",  hidden=false)
	private int currentPageNo;
	
	 /** SQL의 조건절에 사용되는 첫 RNUM */
	@ApiModelProperty(required = true, value = "페이지 번호", example = "1",  hidden=true)
	private int pageStart;
	
	/** 페이지당 출력할 데이터 개수 */
	@ApiModelProperty(required = false, value = "페이지당 출력할 데이터 개수", example = "10",  hidden=true)
    private int recordsPerPage;
    
    
    public int getPageStart() {
        return (this.currentPageNo-1)*recordsPerPage;
    }
    
    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 10;
    }
    
    public void setCurrentPageNo(int currentPageNo) {
        if(currentPageNo <= 0) {
            this.currentPageNo = 1;
        } else {
            this.currentPageNo = currentPageNo;
        }
    }

    public void setRecordsPerPage(int requestRecordsPerPage) {
        this.recordsPerPage =  requestRecordsPerPage != this.recordsPerPage ? requestRecordsPerPage : this.recordsPerPage ;
    }
}
