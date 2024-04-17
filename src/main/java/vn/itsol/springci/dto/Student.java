package vn.itsol.springci.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String fullName;
    private String hometown;
}
