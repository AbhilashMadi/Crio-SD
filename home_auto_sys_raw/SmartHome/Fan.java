package home_auto_sys_raw.SmartHome;

public class Fan implements SmartHomeDevice {
    private boolean status;

    @Override
    public void turnOn() {
        status = true;
        System.out.println("Fan turned on ✅");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println("Fan turned off 👍");
    }

    @Override
    public String getStatus() {
        return status
                ? "on"
                : "off";
    }
}
