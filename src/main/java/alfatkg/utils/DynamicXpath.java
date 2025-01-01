package alfatkg.utils;

public final class DynamicXpath {

    private DynamicXpath() {
    }

    public static String xpath(String dynamicPath, String locatorAttribute) {
        return String.format(dynamicPath, locatorAttribute);
    }

    public static String xpath(String dynamicPath, String locatorAttribute1, String locatorAttribute2) {
        return String.format(dynamicPath, locatorAttribute1, locatorAttribute2);
    }

}