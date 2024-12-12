package smart_home.smartHome;

import smart_home.exception.UnknownFanSpeedException;

public class Fan extends GenericElectricDevice {
    int fanSpeed = 3;

    public Fan(String deviceName, String location) {
        super(deviceName, location);
    }

    public Integer getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(Integer speed) throws UnknownFanSpeedException {
        if (speed > 5 || speed < 1) {
            throw new UnknownFanSpeedException(speed);
        }
        fanSpeed = speed;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "fanSpeed=" + fanSpeed +
                "} " + super.toString();
    }
}
