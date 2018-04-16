package com.example.easynotes.convert;

import com.example.easynotes.model.Note;
import com.example.easynotes.resource.NoteResource;
import org.springframework.stereotype.Service;

@Service
public class NoteConvertServiceimpl implements NoteConvertService {
    @Override
    public NoteResource convert(Note note){

        return NoteResource.builder()
                .content(note.getContent())
                .title(note.getTitle())
                .noteStatus(note.getNoteStatus())
                .noteId(note.getId())
                .createdDate(note.getCreatedAt())
                .build();




    }
}
