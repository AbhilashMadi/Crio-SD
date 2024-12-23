package smart_home.smartHome;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

public class GenericElectricDevice {
    private String deviceName;
    private String location;

    private boolean onOffStatus = Boolean.FALSE;

    public GenericElectricDevice(String deviceName, String location){
        this.deviceName = deviceName;
        this.location = location;
    }

    public String getDeviceName(){
        return deviceName;
    }

    public String getLocation(){
        return location;
    }

    public boolean getOnOffStatus(){
        return onOffStatus;
    }

    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setOnOffStatus(boolean status){
        this.onOffStatus = status;
    }

    @Override
    public String toString(){
        return "GenericElectricDevice{" +
                "deviceName='" + deviceName + '\'' +
                ", location='" + location + '\'' +
                ", onOffStatus=" + onOffStatus +
                '}';
    }
}
