
package com.example.seckill.pojo.doo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_seckill_goods")
@Entity
public class TbSeckillGoods implements Serializable {

  @Id
  private Long id;
  private Long goodsId;
  private Long itemId;
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
