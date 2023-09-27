public class Main {
    public static void main(String[] args) {
        Icon icon1 = IconFactory.getIcon("PDF");
        Icon icon2 = IconFactory.getIcon("PDF");

        System.out.println(icon1.getAttribute());  // Output: "original"
        System.out.println(icon2.getAttribute());  // Output: "original"
    }
}

class Icon {
    private String iconType;
    private String attribute;

    public Icon(String iconType) {
        this.iconType = iconType;
        this.attribute = "original";
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}

class IconFactory {
    private static final java.util.HashMap<String, Icon> icons = new java.util.HashMap<>();

    public static Icon getIcon(String iconType) {
        if (!icons.containsKey(iconType)) {
            icons.put(iconType, new Icon(iconType));
        }
        return icons.get(iconType);
    }
}
