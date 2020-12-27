package com.example.japan.model;

public class VocabularyHandBook {
    private int id;
    private String jWord;
    private String vnWord;
    private String type;
    private String dateCreate;
    private int idHandBook;

    public VocabularyHandBook() {
    }

    public VocabularyHandBook(int id, String jWord, String vnWord, String type, String dateCreate,int idHandBook) {
        this.id = id;
        this.jWord = jWord;
        this.vnWord = vnWord;
        this.type = type;
        this.dateCreate = dateCreate;
        this.idHandBook = idHandBook;
    }

    public int getIdHandBook() {
        return idHandBook;
    }

    public void setIdHandBook(int idHandBook) {
        this.idHandBook = idHandBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getjWord() {
        return jWord;
    }

    public void setjWord(String jWord) {
        this.jWord = jWord;
    }

    public String getVnWord() {
        return vnWord;
    }

    public void setVnWord(String vnWord) {
        this.vnWord = vnWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
}
