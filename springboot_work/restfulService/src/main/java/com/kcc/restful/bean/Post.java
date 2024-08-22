package com.kcc.restful.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Integer user_id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
//    private User user;
}
