package com.example.seckill.common.Utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一结果返回类
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnDTO<T> implements Serializable {
    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码(成功：200：参数错误：400；系统异常：500)", required = true)
    private Integer code;

    /**
     * 消息
     */
    @ApiModelProperty(value = "消息", required = true)
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据", required = true)
    private T data;

    public ReturnDTO(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构建统一返回对象
     * @param code 状态码
     * @param msg 消息
     * @param data 数据
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static <T> ReturnDTO<T> build(Integer code,String msg,T data) {
        return new ReturnDTO<>(code,msg,data);
    }

    /**
     * 构建统一返回对象
     * @param returnEnum 返回枚举类
     * @param data 数据
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static <T> ReturnDTO<T> build(ReturnEnum returnEnum,T data) {
        return new ReturnDTO<>(returnEnum.getCode(),returnEnum.getMsg(),data);
    }


    /**
     * 构建统一返回对象
     * @param returnEnum 返回枚举类
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static <T> ReturnDTO<T> build(ReturnEnum returnEnum) {
        return new ReturnDTO<>(returnEnum.getCode(),returnEnum.getMsg());
    }

    /**
     * 构建统一返回对象
     * @param code 状态码
     * @param msg 消息
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static <T> ReturnDTO<T> build(Integer code,String msg) {
        return new ReturnDTO<>(code,msg,null);
    }

    /**
     * 成功返回,没有数据
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static ReturnDTO<Void> ok() {
        return new ReturnDTO<>(ReturnEnum.OK.getCode(), ReturnEnum.OK.getMsg());
    }

    /**
     * 成功返回，有数据对象
     * @param data 数据
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static <T> ReturnDTO<T> ok(T data) {
        return new ReturnDTO<>(ReturnEnum.OK.getCode(), ReturnEnum.OK.getMsg(),data);
    }


    /**
     * 系统异常返回
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static ReturnDTO error() {
        return new ReturnDTO<>(ReturnEnum.ERROR.getCode(), ReturnEnum.ERROR.getMsg());
    }

    /**
     * 系统异常返回
     * @param msg 异常消息
     * @return ReturnDTO
     * @date 2019/9/24 10:38
     * 
     */
    public static ReturnDTO error(String msg) {
        return new ReturnDTO<>(ReturnEnum.ERROR.getCode(),msg);
    }

    @Getter
    public enum ReturnEnum{

        /**
         * 正常返回
         */
        OK(200,"正常"),


        /**
         * 系统异常返回
         */
        PARAM_ERROR(400,"参数错误"),

        /**
         * 系统异常返回
         */
        ERROR(500,"系统异常"),

        /**
         * 暂不支持
         */
        NOT_SUPPORT(600,"暂不支持"),

        /**
         * 暂不支持
         */
        DATA_ERROR(700,"数据异常"),

        SUCCESS(200, "success"),
        ;

        private final int code;
        private final String msg;

        ReturnEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }





}
