package com.telekom.web.util;

import java.util.Calendar;
import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class MainExceptionHandler extends ExceptionHandlerWrapper {

    private static Log log = LogFactory.getLog(MainExceptionHandler.class);
    private ExceptionHandler wrapped;


    public MainExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        //Iterate over all unhandeled exceptions
        Iterator i = getUnhandledExceptionQueuedEvents().iterator();

        while (i.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) i.next();
            ExceptionQueuedEventContext context =
                    (ExceptionQueuedEventContext) event.getSource();

            //obtain throwable object
            Throwable t = context.getException();

            //here you do what ever you want with exception
            try {
                //log error
                //log.error("Serious error happened!", t);
                FacesMessage mesaj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata", t.getMessage());
                FacesContext.getCurrentInstance().addMessage("Hata", mesaj);
                //redirect to error view etc....
            } finally {
                //after exception is handeled, remove it from queue
                i.remove();
            }
        }

        //let the parent handle the rest
        getWrapped().handle();
    }


    public String getUserName() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return "Test";
        } else {
            User u = (User) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return u.getUsername();
        }
    }
}
