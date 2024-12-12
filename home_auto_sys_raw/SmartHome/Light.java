package home_auto_sys_raw.SmartHome;

public class Light implements SmartHomeDevice {
    private boolean status;

    @Override
    public void turnOn() {
        status = true;
        System.out.println("Light turned on ✅");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println("Light turned off 👍");
    }

    @Override
    public String getStatus() {
        return status
                ? "on"
                : "off";
    }
}
