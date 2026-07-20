package com.factory;

public abstract class DocumentFactory {
    public abstract Document createDocument();
    
    public Document getDocument() {
        Document document = createDocument();
        document.create();
        return document;
    }
}
