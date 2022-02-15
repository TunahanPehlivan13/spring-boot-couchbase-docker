package com.tp.todo.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO better approach is to use exception handler by passing parameters
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Failed to create due to lack of required params!")
public class NoteCreationException extends RuntimeException {
}
