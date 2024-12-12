package smart_home.smartHome;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

import java.util.HashMap;

public class SmartHomeFactory {

    HashMap<String, SmartHomeDevice> smartHomeDeviceSet = new HashMap<>();

    public SmartHomeDevice getSmartHomeDevice(String deviceName, String location) {
        if(location == null)
            location = "";
        String hash = deviceName + " - " + location;
        if(smartHomeDeviceSet.containsKey(hash))
            return smartHomeDeviceSet.get(hash);
        SmartHomeDevice device = null;
        if (deviceName.contains("Fan") || deviceName.contains("fan")) {
            device = new Fan(deviceName, location);
        } else if (deviceName.contains("Light") || deviceName.contains("light")) {
            device = new Light(deviceName, location);
        }
        else
            device = new GenericElectricDevice(deviceName, location);
        smartHomeDeviceSet.put(hash, device);
        return device;
    }


}