
package com.example.seckill.pojo.doo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_seckill_goods")
@Entity
public class TbSeckillGoods {

  @Id
  private BigInteger id;
  private BigInteger goodsId;
  private BigInteger itemId;
  private String title;
  private String smallPic;
  private double price;
  private double costPrice;
  private String sellerId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp checkTime;
  private String status;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private Integer num;
  private Integer stockCount;
  private String introduction;


}
