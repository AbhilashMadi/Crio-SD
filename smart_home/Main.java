package smart_home;

import smart_home.exception.NonExistingInterfaceDeviceException;

public class Main {
    public static void main(String[] args) throws NonExistingInterfaceDeviceException {
        HomeAutomationSystem interfaceDeviceController = new HomeAutomationSystem();
        interfaceDeviceController.addInterfaceDevice("Google Home", "Living Room", "OK Google");
        interfaceDeviceController.addInterfaceDevice("Alexa", "Drawing Room", "Alexa");
        System.out.println("---------------------------------------");
        interfaceDeviceController.addSmartHomeDevice("Alexa", "Light", "Drawing Room");
        interfaceDeviceController.addSmartHomeDevice(null, "Smart Charger", null);
        System.out.println("---------------------------------------");
        interfaceDeviceController.connectSmartHomeDevice("Alexa", "Smart Charger", null);
        System.out.println("---------------------------------------");
        interfaceDeviceController.giveCommand("Alexa", "Light", "Drawing Room", "ON");
        interfaceDeviceController.giveCommand("Alexa", "Light", "Drawing Room", "OFF");

    }
}
