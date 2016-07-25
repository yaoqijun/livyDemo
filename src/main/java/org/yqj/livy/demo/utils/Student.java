package org.yqj.livy.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by yaoqijun.
 * Date:2016-07-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{

    private static final long serialVersionUID = 4353150993536456153L;

    private long id;

    private String firstName;

    private String lastName;

    private String gender;

    private int age;
}
