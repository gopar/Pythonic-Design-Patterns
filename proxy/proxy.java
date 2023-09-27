public interface Document {
    void read();
    void write(String content);
}

public class RealDocument implements Document {
    private String content;

    @Override
    public void read() {
        System.out.println("Reading content: " + content);
    }

    @Override
    public void write(String content) {
        this.content = content;
        System.out.println("Writing content: " + content);
    }
}

public class SecureDocumentProxy implements Document {
    private RealDocument realDocument;
    private String password;

    public SecureDocumentProxy(String password) {
        this.password = password;
        this.realDocument = new RealDocument();
    }

    @Override
    public void read() {
        realDocument.read();
    }

    @Override
    public void write(String content) {
        if ("correct_password".equals(this.password)) {
            realDocument.write(content);
        } else {
            System.out.println("Unauthorized: Incorrect password for write operation.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Document secureDoc = new SecureDocumentProxy("correct_password");
        secureDoc.write("Hello, world!");  // Successful write operation
        secureDoc.read();  // Reads the content

        Document wrongPasswordDoc = new SecureDocumentProxy("wrong_password");
        wrongPasswordDoc.write("This won't work");  // Unsuccessful write operation
        wrongPasswordDoc.read();  // Reads the content (potentially empty or old)
    }
}
