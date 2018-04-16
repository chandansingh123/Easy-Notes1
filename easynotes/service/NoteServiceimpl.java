package com.example.easynotes.service;


import com.example.easynotes.dto.NoteDto;
import com.example.easynotes.exception.resourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.NoteStatus;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.resource.NoteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class NoteServiceimpl implements NoteService {
    private final NoteRepository noteRepository;
    @Autowired
    public NoteServiceimpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    @Override
    public List<Note> findall(){
        return noteRepository.findAll();
    }

    @Override
    public Note addNewNote(NoteDto noteDto) {
        Note note=  new Note();
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        note.setNoteStatus(NoteStatus.ACTIVE);
        return note;
    }

    @Override
    public Note noteUpdate(NoteDto noteDetails, Long noteId) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new resourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

         return noteRepository.save(note);

       // return updatedNote;

    }

    @Override
    public Note addNewNote(Note noteDetais, Object noteId) {
        return noteDetais;
    }

    @Override
    public Note noteDelete(NoteDto noteDto, Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("Note", "id", id));

        note.setNoteStatus(NoteStatus.INACTIVE);
        return noteRepository.save(note);
    }

    @Override
    public Note findByid(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("Note", "id", id));
    }


}
