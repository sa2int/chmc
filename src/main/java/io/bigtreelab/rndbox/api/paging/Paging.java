package io.bigtreelab.rndbox.api.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	
	@JsonIgnore
	private Criteria criteria;
	@ApiModelProperty(required = false, value = "페이지 번호", example = "1", hidden = false)
    private int toalRecordCount;
	@ApiModelProperty(required = false, value = "페이지 번호", example = "1", hidden = false)
    private int startPage;
	@ApiModelProperty(required = false, value = "페이지 번호", example = "1", hidden = false)
    private int endPage;
    /** 이전 페이지 존재 여부 */
	@ApiModelProperty(required = false, value = "[APP용]이전 페이지 존재 여부", example = "true/false", hidden = false)
	private boolean hasPreviousPage;
    /** 다음 페이지 존재 여부 */
	@ApiModelProperty(required = false, value = "[APP용]다음 페이지 존재 여부", example = "true/false", hidden = false)
    private boolean hasNextPage;
	/** 이전 페이지 존재 여부 */
	@ApiModelProperty(required = false, value = "이전 페이지 존재 여부-페이지 사이즈 단위", example = "true/false", hidden = false)
	private boolean hasPreviousPageByPageSize;
	/** 다음 페이지 존재 여부 */
	@ApiModelProperty(required = false, value = "다음 페이지 존재 여부-페이지 사이즈 단위", example = "true/false", hidden = false)
	private boolean hasNextPageByPageSize;
    
    /** 화면 하단에 출력할 페이지 사이즈 */
    private int pageSize=10;
    

    public void setTotalRecordCount(int toalRecordCount) {
        this.toalRecordCount = toalRecordCount;
        calcData();
    }
    
    private void calcData() {
        
        endPage = (int) (Math.ceil(criteria.getCurrentPageNo() / (double) pageSize) * pageSize);
 
        startPage = (endPage - pageSize) + 1;
        if(startPage <= 0) startPage = 1;
        
        int tempEndPage = (int) (Math.ceil(toalRecordCount / (double) criteria.getRecordsPerPage()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
 
		hasPreviousPageByPageSize = startPage == 1 ? false : true;
		hasNextPageByPageSize = endPage * criteria.getRecordsPerPage() < toalRecordCount ? true : false;
		// 현재페이지 이전페이지 존재여부
		hasPreviousPage = criteria.getCurrentPageNo() == 1 ? false : true;
		// 현재페이지 다음페이지 존재여부
		hasNextPage = criteria.getCurrentPageNo() < endPage ? true : false;
        
    }
   
 
}
