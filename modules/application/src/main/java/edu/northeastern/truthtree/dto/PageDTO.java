package edu.northeastern.truthtree.dto;

import java.util.List;


/**
 * Created by steven on 2019/4/11.
 */
public class PageDTO<T> {
  private final Integer currentPage;
  private final Integer totalPageCount;
  private final Integer totalItemCount;
  private final List<T> items;

  private PageDTO(Builder builder) {
    this.currentPage = builder.currentPage;
    this.totalPageCount = builder.totalPageCount;
    this.totalItemCount = builder.totalItemCount;
    this.items = builder.items;
  }

  public Integer getCurrentPage() {
    return this.currentPage;
  }

  public Integer getTotalPageCount() {
    return this.totalPageCount;
  }

  public Integer getTotalItemCount() {
    return this.totalItemCount;
  }

  public List<T> getItems() {
    return this.items;
  }

  public static class Builder<T> {
    private Integer currentPage;
    private Integer totalPageCount;
    private Integer totalItemCount;
    private List<T> items;

    public Builder withCurrentPage(Integer currentPage) {
      this.currentPage = currentPage;
      return this;
    }

    public Builder withTotalPageCount(Integer totalPageCount) {
      this.totalPageCount = totalPageCount;
      return this;
    }

    public Builder withTotalItemCount(Integer totalItemCount) {
      this.totalItemCount = totalItemCount;
      return this;
    }

    public Builder withItems(List<T> items) {
      this.items = items;
      return this;
    }

    public PageDTO<T> build() {
      return new PageDTO(this);
    }
  }
}
