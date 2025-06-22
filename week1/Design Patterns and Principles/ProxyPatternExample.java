public class ProxyPatternExample{
    public static void main(String[] args) {
        Image img1 = new ProxyImage("pic1.jpg");
        Image img2 = new ProxyImage("pic2.jpg");

        img1.display(); // loads and displays
        System.out.println();
        img1.display(); // cached display

        System.out.println();
        img2.display();
    }
}

// Subject Interface
interface Image {
    void display();
}

// Real Subject Class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from server...");
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // lazy initialization
        }
        realImage.display();
    }
}
