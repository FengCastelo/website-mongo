package com.fengcastelo.webservice.dtos;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class CommentDTO implements Serializable {

    private String id;
    private AuthorDTO author;
    private String body;


}
