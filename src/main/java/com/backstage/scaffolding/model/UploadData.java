package com.backstage.scaffolding.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 上传数据
 * @author DevilChen
 */
@Data
public class UploadData implements Serializable {

    private String string;

    private Date date;

    private Double doubleData;
}