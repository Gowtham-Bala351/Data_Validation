package ex.valid.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException except)
	{
		List<FieldError> er=except.getBindingResult().getFieldErrors();
		Map<String,String> error=new HashMap<>();
		for(FieldError fielderr:er) 
		{
			error.put(fielderr.getField(), fielderr.getDefaultMessage());
		}
		return ResponseEntity.badRequest().body(error);
	}
}
