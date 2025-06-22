
public class FactoryMethodPattern{
    public static void main(String[] args) {

        // Create Word File using WordCreator
        DocumentCreator wordCreator = new WordCreator();
        Document wordFile = wordCreator.generateDocument();
        wordFile.display();

        // Create PDF File using PdfCreator
        DocumentCreator pdfCreator = new PdfCreator();
        Document pdfFile = pdfCreator.generateDocument();
        pdfFile.display();

        // Create Excel File using ExcelCreator
        DocumentCreator excelCreator = new ExcelCreator();
        Document excelFile = excelCreator.generateDocument();
        excelFile.display();
    }
}

//Document interface
interface Document {
    void display();
}

//Concrete Document class
class WordFile implements Document {
    public void display() {
        System.out.println("Opening Word file.");
    }
}

class PdfFile implements Document {
    public void display() {
        System.out.println("Opening PDF file.");
    }
}

class ExcelFile implements Document {
    public void display() {
        System.out.println("Opening Excel file.");
    }
}

//Abstract Factory class
abstract class DocumentCreator {
    public abstract Document generateDocument();
}

//Concrete Factory classes
class WordCreator extends DocumentCreator {
    public Document generateDocument() {
        return new WordFile();
    }
}

class PdfCreator extends DocumentCreator {
    public Document generateDocument() {
        return new PdfFile();
    }
}

class ExcelCreator extends DocumentCreator {
    public Document generateDocument() {
        return new ExcelFile();
    }
}

