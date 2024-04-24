package com.fct.BackEnd.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private String _id;
    private String username;
    private int privilege_level;
}
