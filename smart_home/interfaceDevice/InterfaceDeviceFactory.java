package smart_home.interfaceDevice;

import smart_home.exception.ExistingInterfaceDeviceException;
import smart_home.exception.NonExistingInterfaceDeviceException;

import java.util.HashMap;

public class InterfaceDeviceFactory {
    private final HashMap<String, InterfaceDevice> activationKeyDevices = new HashMap<>();

    public InterfaceDevice createInterfaceDevice(String interfaceName, String location, String activationKey) throws ExistingInterfaceDeviceException {
        if (activationKeyDevices.containsKey(activationKey)) {
            throw new ExistingInterfaceDeviceException(interfaceName);
        }

        InterfaceDevice interfacedevice = new DefaultInterfaceDevice(interfaceName, location, activationKey);
        activationKeyDevices.put(activationKey, interfacedevice);

        return interfacedevice;
    }

    public InterfaceDevice getInterfaceDevice(String activationKey) throws NonExistingInterfaceDeviceException {
        if (activationKeyDevices.containsKey(activationKey)) {
            return activationKeyDevices.get(activationKey);
        }

        throw new NonExistingInterfaceDeviceException(activationKey);
    }
}
