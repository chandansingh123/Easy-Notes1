package com.example.easynotes.resource;

import com.example.easynotes.model.NoteStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class NoteResource  {


    private Long noteId;
    private String title;
    private String content;
    private Date createdDate;
    protected NoteStatus noteStatus;
}
