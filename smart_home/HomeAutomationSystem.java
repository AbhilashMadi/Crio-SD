package smart_home;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;
import smart_home.command.Command;
import smart_home.command.CommandFactory;
import smart_home.command.Invoker;
import smart_home.exception.ExistingInterfaceDeviceException;
import smart_home.exception.NonExistingInterfaceDeviceException;
import smart_home.interfaceDevice.InterfaceDevice;
import smart_home.interfaceDevice.InterfaceDeviceFactory;
import smart_home.smartHome.SmartHomeFactory;

public class HomeAutomationSystem {

    Invoker invoker = new Invoker();
    SmartHomeFactory smartHomeFactory = new SmartHomeFactory();
    CommandFactory commandFactory = new CommandFactory();
    InterfaceDeviceFactory interfaceDeviceFactory = new InterfaceDeviceFactory();

    public void addInterfaceDevice(String interfaceName, String location, String activationKey) {
        try {
            InterfaceDevice interfaceDevice = interfaceDeviceFactory.createInterfaceDevice(interfaceName, location, activationKey);
            System.out.println("Added Interface Device: " + interfaceName + " at " + location);
        } catch (ExistingInterfaceDeviceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addSmartHomeDevice(String activationKey, String name, String location) {
        SmartHomeDevice smartHomeDevice = smartHomeFactory.getSmartHomeDevice(name, location);
        if (activationKey == null) {
            System.out.println("Added Smart Home Device: " + name + " at "+ location );
            return;
        }
        InterfaceDevice device = null;
        try {
            device = interfaceDeviceFactory.getInterfaceDevice(activationKey);
        } catch (NonExistingInterfaceDeviceException e) {
            throw new RuntimeException(e);
        }
        assert device != null;
        device.connectSmartDevice(smartHomeDevice);

        System.out.println("\n Connected Smart Home Device: " + smartHomeDevice + " to Interface Device: " + device + "\n");
        return;
    }

    public void connectSmartHomeDevice(String activationKey, String name, String location) {
        InterfaceDevice device = null;
        try {
            device = interfaceDeviceFactory.getInterfaceDevice(activationKey);
        } catch (NonExistingInterfaceDeviceException e) {
            System.out.println(e.getMessage());
        }
        SmartHomeDevice smartHomeDevice = smartHomeFactory.getSmartHomeDevice(name, location);
        device.connectSmartDevice(smartHomeDevice);
        System.out.println("Connected Smart Home Device: " + smartHomeDevice + " to Interface Device: " + device);
    }

    public void giveCommand(String activationKey, String name, String location, String commandString) {
        InterfaceDevice device = null;
        try {
            device = interfaceDeviceFactory.getInterfaceDevice(activationKey);
        } catch (NonExistingInterfaceDeviceException e) {
            System.out.println(e.getMessage());
        }
        SmartHomeDevice smartHomeDevice = smartHomeFactory.getSmartHomeDevice(name, location);
        if (!device.getConnectedSmartDevices().contains(smartHomeDevice)) {
            System.out.println("Smart Home Device is not connected to Interface Device");
            return;
        }
        Command command = null;
        try {
            command = commandFactory.getCommand(smartHomeDevice, commandString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        invoker.invoke(command);
        System.out.println("Executed Command: " + commandString + " on Smart Home Device: " + smartHomeDevice);
    }
}
