package com.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create Word document using factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.getDocument();
        wordDoc.open();
        wordDoc.save();
        System.out.println();

        // Create PDF document using factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.getDocument();
        pdfDoc.open();
        pdfDoc.save();
        System.out.println();

        // Create Excel document using factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.getDocument();
        excelDoc.open();
        excelDoc.save();
    }
}
