package br.edu.uni7.projetovp2.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceptionCompras extends RuntimeException{
}
