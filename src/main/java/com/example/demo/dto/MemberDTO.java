package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    // feild
    private String name;
    private String email;
    private String organization;

    // window = alt + insert

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(String organization) {
//        this.organization = organization;
//    }
//    @Override
//    public String toString() {
//        return "MemberDTO{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", organization='" + organization + '\'' +
//                '}';
//    }
}
