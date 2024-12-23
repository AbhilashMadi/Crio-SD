package home_auto_sys_raw;

import home_auto_sys_raw.Interface.InterfaceDevice;
import home_auto_sys_raw.Interface.InterfaceDeviceFactory;
import home_auto_sys_raw.Interface.InterfaceDeviceImpl;
import home_auto_sys_raw.SmartHome.Light;
import home_auto_sys_raw.SmartHome.SmartHomeDevice;
import home_auto_sys_raw.SmartHome.SmartHomeDeviceFactory;
import home_auto_sys_raw.SmartHome.SmartHomeDeviceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Assume that InterfaceDevice and SmartDevice classes, along with their sub-classes, already exist

public class HomeAutomationSystem {
    private final Map<String, InterfaceDevice> interfaceDevices = new HashMap<>();
    private final Map<String, SmartHomeDevice> smartHomeDevices = new HashMap<>();
    private final Map<String, Set<String>> deviceInterfaceMapping = new HashMap<>();


    private final InterfaceDeviceFactory interfaceDeviceFactory = new InterfaceDeviceImpl();
    private final SmartHomeDeviceFactory smartHomeDeviceFactory = new SmartHomeDeviceImpl();

    public void addInterfaceDevice(String name, String location, String activationKeyword) {
        String uniqueKey = activationKeyword + "@" + location;
        if (!interfaceDevices.containsKey(uniqueKey)) {
            InterfaceDevice device = interfaceDeviceFactory.createInterfaceDevice(name, activationKeyword);
            if (device != null) {
                interfaceDevices.put(uniqueKey, device);
                System.out.println("Added Interface Device: " + name + " at " + location);
            }
        } else {
            System.out.println("Invalid Input: Interface Device with this name and location already exists.");
        }
    }

    public void addSmartHomeDevice(String activationKeyword, String deviceName, String location) {
        String uniqueIdentifier = deviceName + "@" + location;
        String interfaceIdentifier = activationKeyword + "@" + location;
        if (!smartHomeDevices.containsKey(uniqueIdentifier) && interfaceDevices.containsKey(interfaceIdentifier)) {
            SmartHomeDevice device = smartHomeDeviceFactory.createSmartHomeDevice(deviceName);
            if (device != null) {
                smartHomeDevices.put(uniqueIdentifier, device);
                System.out.println("Added SmartHome Device: " + deviceName + " at " + location);
                connectSmartHomeDevice(activationKeyword, deviceName, location);
            }
        } else if (smartHomeDevices.containsKey(uniqueIdentifier)) {
            System.out.println("Invalid Input: SmartHome Device with this name and location already exists.");
        } else {
            System.out.println("Invalid Input: SmartHome Device  ");
        }
    }

    public void giveCommand(String activationKeyword, String deviceName, String location, String commandValue) {
        String deviceIdentifier = deviceName + "@" + location;

        if (isDeviceConnectedToInterface(deviceIdentifier, activationKeyword)) {
            SmartHomeDevice device = smartHomeDevices.get(deviceIdentifier);
            switch (commandValue.toLowerCase()) {
                case "on":
//                    device.turnOn();
                    break;
                case "off":
//                    device.turnOff();
                    break;
                default:
                    System.out.println("Sorry, Invalid Command Description");
                    return;
            }
            System.out.println("OK, " + commandValue + " command executed for " + deviceName);
        } else if (!isDeviceConnectedToInterface(deviceIdentifier, activationKeyword)){
            System.out.println("The device " + deviceName + " at " + location + " is not connected to an interface with the activation keyword '" + activationKeyword + "'.");
        }
    }


    public void printConnectedDevices(String activationKeyword, String location) {
        System.out.println("Command : "+ activationKeyword+ " Print Connected devices at " + location );
        // System.out.println(deviceIdentifier);
        smartHomeDevices.forEach((deviceIdentifier, device) -> {
            if (deviceIdentifier.endsWith("@" + location) && isDeviceConnectedToInterface(deviceIdentifier, activationKeyword)) {
//                System.out.println(deviceIdentifier.split("@")[0] + " : " + device.getStatus());
            }
        });
    }

    private boolean isDeviceConnectedToInterface(String deviceIdentifier, String activationKeyword) {

        if (deviceInterfaceMapping.containsKey(deviceIdentifier)) {
            return deviceInterfaceMapping.get(deviceIdentifier).stream()
                    .anyMatch(interfaceId -> interfaceDevices.get(interfaceId).getActivationKeyword().equals(activationKeyword));
        }
        return false;
    }



    public void connectSmartHomeDevice(String activationkeyword, String SmartHomedeviceName, String location) {
        String deviceIdentifier = SmartHomedeviceName + "@" + location;
        String interfaceIdentifier = activationkeyword + "@" + location; // Unique identifier for interface device

        // Check if both the SmartHome device and the Interface device exist
        if (smartHomeDevices.containsKey(deviceIdentifier) && interfaceDevices.containsKey(interfaceIdentifier)) {
            deviceInterfaceMapping.computeIfAbsent(deviceIdentifier, k -> new HashSet<>()).add(interfaceIdentifier);
            System.out.println("Connected " + SmartHomedeviceName + " at " + location + " to " + getInterfaceDeviceName(activationkeyword, location));
        } else if (interfaceDevices.containsKey(interfaceIdentifier)) {
            System.out.println("Invalid Input: Interface device not found at the location "+ location);
        } else {
            System.out.println("Invalid Input: "+ SmartHomedeviceName + " not found at the location "+ location);
        }
    }


    // Disconnect a SmartHome device from an interface device
    public void disconnectSmartHomeDevice(String interfaceName, String deviceName, String location) {
        String uniqueIdentifier = deviceName + "@" + location;
        Set<String> connectedInterfaces = deviceInterfaceMapping.get(uniqueIdentifier);
        if (connectedInterfaces != null ) {
            System.out.println("Disconnected " + deviceName + " at " + location + " from " + interfaceName);
            deviceInterfaceMapping.remove(uniqueIdentifier);
        } else if (!smartHomeDevices.containsKey(uniqueIdentifier)){
            System.out.println("Invalid Input:"+ deviceName+ " not found at the location "+ location);
        }
        else if (!interfaceDevices.containsKey(interfaceName + "@" + location)){
            System.out.println("Invalid Input:"+ interfaceName + " not found at the location "+ location);
        }
        else{
            System.out.println(deviceName + " is not connected to " + interfaceName + " at " + location);
        }


    }

    public void giveSpecialCommand(String activationKeyword, String specialCommand) {
        System.out.println(" Received special command: " + activationKeyword + " "+  specialCommand);

        switch (specialCommand.toLowerCase()) {
            case "i am home":
                turnOnConnectedDevices(activationKeyword);
                break;
            case "leaving home":
                turnOffConnectedDevices(activationKeyword);
                break;
            case "good night":
                turnOffConnectedLights(activationKeyword);
                break;
            default:
                System.out.println("Sorry, Unknown Special Command");
        }
    }

    private void turnOnConnectedDevices(String activationKeyword) {
        deviceInterfaceMapping.forEach((deviceIdentifier, connectedInterfaces) -> {
            if (isInterfaceConnectedToDevice(activationKeyword, connectedInterfaces)) {
                SmartHomeDevice device = smartHomeDevices.get(deviceIdentifier);
//                device.turnOn();
            }
        });
        System.out.println("Connected devices turned on");
    }

    private void turnOffConnectedDevices(String activationKeyword) {
        deviceInterfaceMapping.forEach((deviceIdentifier, connectedInterfaces) -> {
            if (isInterfaceConnectedToDevice(activationKeyword, connectedInterfaces)) {
                SmartHomeDevice device = smartHomeDevices.get(deviceIdentifier);
//                device.turnOff();
            }
        });
        System.out.println("Connected devices turned off");
    }

    private void turnOffConnectedLights(String activationKeyword) {
        deviceInterfaceMapping.forEach((deviceIdentifier, connectedInterfaces) -> {
            if (isInterfaceConnectedToDevice(activationKeyword, connectedInterfaces)) {
                SmartHomeDevice device = smartHomeDevices.get(deviceIdentifier);
                if (device instanceof Light) {
//                    device.turnOff();
                }
            }
        });
        System.out.println("Connected lights turned off");
    }

    private boolean isInterfaceConnectedToDevice(String activationKeyword, Set<String> connectedInterfaces) {
        return connectedInterfaces.stream()
                .anyMatch(interfaceId -> interfaceDevices.get(interfaceId).getActivationKeyword().equals(activationKeyword));
    }


    public String getInterfaceDeviceName(String activationKeyword, String location) {
        String interfaceIdentifier = activationKeyword + "@" + location;

        if (interfaceDevices.containsKey(interfaceIdentifier)) {
            InterfaceDevice interfaceDevice = interfaceDevices.get(interfaceIdentifier);
            return interfaceDevice.getName();
        } else {
            System.out.println("Interface Device with activation keyword '" + activationKeyword + "' not found at location " + location);
            return null;
        }
    }
}