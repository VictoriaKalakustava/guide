package com.itransition.guide.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private Long instructionId;
    private Long userId;
    private String userLogin;
    private String value;
    private String userImg;
}
