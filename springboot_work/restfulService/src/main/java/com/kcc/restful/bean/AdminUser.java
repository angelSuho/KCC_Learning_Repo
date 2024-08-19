package com.kcc.restful.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter(("UserInfo"))
public class AdminUser {
    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    @Past(message = "등록일은 오늘 날짜보다 이전 날짜여야 합니다.")
    private Date joinDate;

    private String password;
    private String ssn;
}
