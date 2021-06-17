package com.app.sajana.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "todo")
public class Todo {
    @Id
    private int todoId;
    private String title;
    private String description;
    private int activeStatus;
    private Date createDate;
    private Date endDate;

}
