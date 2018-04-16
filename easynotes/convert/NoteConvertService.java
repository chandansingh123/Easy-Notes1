package com.example.easynotes.convert;

import com.example.easynotes.model.Note;
import com.example.easynotes.resource.NoteResource;

public interface NoteConvertService {

    NoteResource convert(Note note);
}
