package com.hobart.springbootmall.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderRequest {

  //巢狀Json寫法
  @NotEmpty
  private List<BuyItem> buyItemList;

  public List<BuyItem> getBuyItemList() {
    return buyItemList;
  }

  public void setBuyItemList(List<BuyItem> buyItemList) {
    this.buyItemList = buyItemList;
  }
}
