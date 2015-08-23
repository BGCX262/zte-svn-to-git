package com.telekom.web.util;


import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class MainExceptionHandlerFactory extends ExceptionHandlerFactory {

  private ExceptionHandlerFactory parent;

  // this injection handles jsf
  public MainExceptionHandlerFactory(ExceptionHandlerFactory parent) {
    this.parent = parent;
  }

  //create your own ExceptionHandler
  @Override
  public ExceptionHandler getExceptionHandler() {
    ExceptionHandler result =
        new MainExceptionHandler(parent.getExceptionHandler());
    return result;
  }
}
