package pers.selton.vertx.model.data;

import lombok.Data;
import lombok.ToString;
import pers.selton.vertx.model.po.BaseEntity;

@Data
@ToString(callSuper = true)
public class User extends BaseEntity {

    private String name;
    private int age;
}
