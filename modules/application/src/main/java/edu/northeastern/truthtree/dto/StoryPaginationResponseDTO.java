package edu.northeastern.truthtree.dto;

import java.util.List;

public class StoryPaginationResponseDTO {
  private List<StoryDTO> data;
  private int total;

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  private int totalPage;

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  private int currentPage;
  private int pageSize;

  public void setData(List<StoryDTO> data) {
    this.data = data;
  }

  public List<StoryDTO> getData() {
    return this.data;
  }


}
