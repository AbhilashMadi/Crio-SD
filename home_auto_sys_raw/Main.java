package home_auto_sys_raw;

public class Main {

    public static void main(String[] args) {
        // Initialize the Home Automation System
        HomeAutomationSystem system = new HomeAutomationSystem();

        // Adding interface devices
        system.addInterfaceDevice("Google Home", "Living Room", "OK Google");
        system.addInterfaceDevice("Alexa", "Drawing Room", "Alexa");
        system.addInterfaceDevice("Alexa", "Kitchen", "Alexa");
        System.out.println("-------------------------------------------");

        // Adding SmartHome devices
        system.addSmartHomeDevice("Alexa", "Light", "Drawing Room");
        system.addSmartHomeDevice("Alexa","Light", "Kitchen");
        system.addSmartHomeDevice( "OK Google", "Fan", "Living Room");
        system.addSmartHomeDevice( "OK Google", "Light", "Living Room");

        System.out.println("-------------------------------------------");

        // Example commands
        system.giveCommand("Alexa", "Light", "Drawing Room", "On");
        system.giveCommand("OK Google", "Fan", "Living Room", "On");
        system.giveCommand("Alexa", "Light", "Kitchen", "On");
        system.giveCommand("Alexa", "Light", "Kitchen", "Off");

        System.out.println("-------------------------------------------");

        // Print connected devices
        system.printConnectedDevices("Alexa", "Drawing Room");
        system.printConnectedDevices("OK Google", "Living Room");

        System.out.println("-------------------------------------------");

        // Disconnecting a device
        system.disconnectSmartHomeDevice("OK Google", "Light", "Living Room");
        system.printConnectedDevices("OK Google", "Living Room");

        System.out.println("-------------------------------------------");

        // Special command
        system.giveSpecialCommand("OK Google", "I am home");
        system.giveSpecialCommand("OK Google", "good night");
    }
}