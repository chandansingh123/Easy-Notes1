package com.example.easynotes.controller;

import com.example.easynotes.convert.NoteConvertService;
import com.example.easynotes.dto.NoteDto;
import com.example.easynotes.model.Note;
import com.example.easynotes.resource.NoteResource;
import com.example.easynotes.service.NoteService;
import org.springframework.web.bind.annotation.*;



import java.util.List;
@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteConvertService noteContvertService;
    private final NoteService noteService;

    public NoteController(NoteConvertService noteConvertService, NoteService noteService) {
        this.noteService = noteService;
        this.noteContvertService=noteConvertService;
    }

    @GetMapping(value = "/notes")
    public List<Note> getallNotes(){
        return noteService.findall();
    }


    @PostMapping(value = "/notes")
    public NoteResource addNewNote(@RequestBody NoteDto noteDto){
        return noteContvertService.convert(noteService.addNewNote(noteDto));
    }

    @PutMapping(value = "/notes/title/{id}")
    public NoteResource update(@PathVariable(value = "id") Long Id,
                               @RequestBody NoteDto noteDto){

        return noteContvertService.convert( noteService.noteUpdate(noteDto,Id));
    }
@PutMapping(value = "/notes/delete/{id}")
    public NoteResource delete(@PathVariable(value = "id") Long Id,
                               @RequestBody NoteDto noteDto){
        return noteContvertService.convert(noteService.noteDelete(noteDto,Id));
}

@GetMapping(value = "/notes/{id}")
    public Note findById(@PathVariable(value = "id") Long Id){
        return noteService.findByid(Id);
}

}
