package com.example.easynotes.service;

import com.example.easynotes.dto.NoteDto;
import com.example.easynotes.model.Note;
import com.example.easynotes.resource.NoteResource;

import java.util.List;

public interface NoteService {
    List<Note> findall();

    Note addNewNote(NoteDto noteDto);


    Note noteUpdate(NoteDto noteDetails, Long noteId);

    Note addNewNote(Note noteDetais, Object noteId);

    Note noteDelete(NoteDto noteDto, Long id);
    Note findByid(Long id);
}
