package com.tp.todo.service;

import com.tp.todo.entity.Note;
import com.tp.todo.repository.NoteRepository;
import com.tp.todo.repository.UserRepository;
import com.tp.todo.service.exception.NoteCreationException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @InjectMocks
    NoteService.DefaultNoteService noteService;

    @Mock
    NoteRepository noteRepository;

    @Mock
    UserRepository userRepository;

    @Captor
    ArgumentCaptor<Note> noteCaptor;

    @Test
    void shouldSaveNote() {
        // given
        Note note = new Note();
        note.setText("text");

        String userId = "userId";

        // when
        when(userRepository.existsById("userId")).thenReturn(true);

        // then
        noteService.saveNote(note, userId);

        verify(noteRepository).save(noteCaptor.capture());
        Note verifiedNote = noteCaptor.getValue();

        assertEquals(verifiedNote.getUserId(), "userId");
    }

    @Test
    void shouldThrowExceptionWhenUserIdDoesNotExist() {
        Note note = new Note();
        note.setText("text");

        String userId = "userId";

        when(userRepository.existsById("userId")).thenReturn(false);

        assertThrows(NoteCreationException.class, () -> noteService.saveNote(note, userId));
    }

    @Test
    void shouldReturnNote() {
        Note note = new Note();
        String userId = "userId";

        when(noteRepository.findById("userId")).thenReturn(Optional.of(note));

        Optional<Note> result = noteService.findNoteBy(userId);

        assertTrue(result.isPresent());
        assertEquals(result.get(), note);
    }

    @Test
    void shouldReturnEmptyNoteWhenNoteDoesNotExist() {
        when(noteRepository.findById("userId")).thenReturn(Optional.empty());

        Optional<Note> result = noteService.findNoteBy("userId");

        assertFalse(result.isPresent());
    }

    @Test
    void shouldReturnNotesByUserId() {
        Note note1 = new Note();
        Note note2 = new Note();

        when(noteRepository.findByUserId("userId")).thenReturn(Lists.newArrayList(note1, note2));

        List<Note> notes = noteService.findByUserId("userId");

        assertThat(notes, hasSize(2));
        assertEquals(notes.get(0), note1);
        assertEquals(notes.get(1), note2);
    }
}