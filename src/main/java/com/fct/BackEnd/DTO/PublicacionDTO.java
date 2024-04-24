package com.fct.BackEnd.DTO;

import java.sql.Date;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {
    private String _id;
    private String user_id;
    private String content;
    private Date timestamp;
    private int vote_count;
}
