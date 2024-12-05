package patterns;

// Factory Design Pattern - (Virtual Constructor)

import java.util.HashMap;
import java.util.Map;

// product interface
interface Document{
    void createDocument();
}

//concrete classes for product interface
class PDFDocumentCreator implements Document{
    @Override
    public void createDocument(){
        System.out.println("PDF creating...");
    }
}

class WordDocumentCreator implements Document{
    @Override
    public void createDocument(){
        System.out.println("Word creating...");
    }
}

class XlDocumentCreator implements Document{
    @Override
    public void createDocument(){
        System.out.println("XL creating...");
    }
}


// factory to generate desired product object
enum DocumentType {
    PDF, XL, WORD;
}

//// creation of a factory method which provides the required object
//abstract class DocumentCreator {
//    public static Document createDocument(DocumentType type){
//        return switch(type){
//            case PDF  -> new PDFDocumentCreator();
//            case XL   -> new XlDocumentCreator();
//            case WORD -> new WordDocumentCreator();
//        };
//    }
//}

//more scalable solution is to hash the required concrete class in a hashmap
abstract class DocumentCreator {
    private static final Map<DocumentType, Document> documentMap = new HashMap<>();

    static {
        documentMap.put(DocumentType.WORD, new PDFDocumentCreator());
        documentMap.put(DocumentType.XL, new WordDocumentCreator());
        documentMap.put(DocumentType.PDF, new XlDocumentCreator());
    }

    public static Document createDocument(DocumentType type){
        return documentMap.get(type);
    }
}

public class FactoryPattern{
    public static void main(String[] args){
        Document pdf = DocumentCreator.createDocument(DocumentType.PDF);
        pdf.createDocument();

        Document xl = DocumentCreator.createDocument(DocumentType.XL);
        xl.createDocument();

        Document word = DocumentCreator.createDocument(DocumentType.WORD);
        word.createDocument();
    }
}

