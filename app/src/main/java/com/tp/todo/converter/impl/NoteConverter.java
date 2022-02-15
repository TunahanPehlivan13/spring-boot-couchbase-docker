package com.tp.todo.converter.impl;

import com.tp.todo.controller.dto.NoteDto;
import com.tp.todo.converter.EntityConverter;
import com.tp.todo.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteConverter implements EntityConverter<NoteDto, Note> {

    @Override
    public NoteDto to(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .text(note.getText())
                .build();
    }

    @Override
    public Note to(NoteDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setText(noteDto.getText());
        return note;
    }
}
