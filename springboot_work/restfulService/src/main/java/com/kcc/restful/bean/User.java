package com.kcc.restful.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//@Entity
@Data
//@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})
public class User {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(title = "사용자 이름", description = "사용자 이름을 입력해 주세요.")
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;

    @Schema(title = "사용자 등록일", description = "사용자 등록일을 입력해 주세요.")
    @Past(message = "등록일은 오늘 날짜보다 이전 날짜여야 합니다.")
    private Date joinDate;

//    @JsonIgnore
    private String password;
//    @JsonIgnore
    private String ssn;

//    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
