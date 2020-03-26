package com.example.seckill.pojo.doo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_seckill_order")
@Entity
@Builder
public class TbSeckillOrder implements Serializable {

  @Id
  private Long id;
  private Long seckillId;
  private double money;
  private String userId;
  private String sellerId;
  private Date createTime;
  private Date payTime;
  private String status;
  private String receiverAddress;
  private String receiverMobile;
  private String receiver;
  private String transactionId;




}
