package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 记录帖子的一些常用状态.
* @TableName forum_info
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumInfo implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer infoId;
    /**
    * 回复数量
    */
    @NotNull(message="[回复数量]不能为空")
    @ApiModelProperty("回复数量")
    private Integer infoReply;
    /**
    * 查看数
    */
    @NotNull(message="[查看数]不能为空")
    @ApiModelProperty("查看数")
    private Integer infoSee;
    /**
    * 最后回复
    */
    @NotBlank(message="[最后回复]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("最后回复")
    @Length(max= 20,message="编码长度不能超过20")
    private String infoLastuser;
    /**
    * 最后回复时间
    */
    @NotNull(message="[最后回复时间]不能为空")
    @ApiModelProperty("最后回复时间")
    private Date infoLastime;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String mainId;

}
