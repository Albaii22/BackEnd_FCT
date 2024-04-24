package com.fct.BackEnd.entities;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "coments")
public class Coments {
    @Id
    private Long _id;

    private Long user_id; 
    private Long post_id; 
    private String content;
    private Date timestamp;
}