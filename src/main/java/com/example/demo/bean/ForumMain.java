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
* 论坛主表
* @TableName forum_main
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumMain implements Serializable {

    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String mainId;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 80,message="编码长度不能超过80")
    @ApiModelProperty("")
    @Length(max= 80,message="编码长度不能超过80")
    private String mainTitle;
    /**
    * main_flag  这是一个标记,记录用户发布在哪个论坛区.
    */
    @NotBlank(message="[main_flag  这是一个标记,记录用户发布在哪个论坛区.]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("main_flag  这是一个标记,记录用户发布在哪个论坛区.")
    @Length(max= 64,message="编码长度不能超过64")
    private String mainFlag;
    /**
    * main_type 记录用户发表在论坛区的哪个栏目下
    */
    @NotBlank(message="[main_type 记录用户发表在论坛区的哪个栏目下]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("main_type 记录用户发表在论坛区的哪个栏目下")
    @Length(max= 64,message="编码长度不能超过64")
    private String mainType;
    /**
    * 内容
    */
    @NotBlank(message="[内容]不能为空")
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("内容")
    @Length(max= -1,message="编码长度不能超过-1")
    private String mainContent;
    /**
    * 创建时间
    */
    @NotNull(message="[创建时间]不能为空")
    @ApiModelProperty("创建时间")
    private Date mainCreatime;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String mainCreatuser;
    /**
    * 精华帖,int类型,精华帖分类型.
    */
    @NotNull(message="[精华帖,int类型,精华帖分类型.]不能为空")
    @ApiModelProperty("精华帖,int类型,精华帖分类型.")
    private Integer mainRecommend;
    /**
    * 是不是被删除的帖子.删除的帖子为y,正常为n
    */
    @NotNull(message="[是不是被删除的帖子.删除的帖子为y,正常为n]不能为空")
    @ApiModelProperty("是不是被删除的帖子.删除的帖子为y,正常为n")
    private String mainDelete;
    /**
    * 
    */
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("")
    @Length(max= 20,message="编码长度不能超过20")
    private String mainNickname;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer mainZan;

}
