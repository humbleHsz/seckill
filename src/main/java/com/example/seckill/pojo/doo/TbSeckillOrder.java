package com.spacetech.lineloss.pojo.doo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_seckill_order")
@Entity
public class TbSeckillOrder {

  @Id
  private Integer id;
  private Integer seckillId;
  private double money;
  private String userId;
  private String sellerId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp payTime;
  private String status;
  private String receiverAddress;
  private String receiverMobile;
  private String receiver;
  private String transactionId;




}
