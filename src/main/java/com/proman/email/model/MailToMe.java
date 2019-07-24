package com.proman.email.model;

import javax.validation.constraints.NotNull;

public class MailToMe {

    @NotNull
    private String subject;
    @NotNull
    private String text;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}