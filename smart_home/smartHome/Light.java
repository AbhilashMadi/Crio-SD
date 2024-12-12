package smart_home.smartHome;

import smart_home.exception.NotPossibleBrigtnessException;
import smart_home.exception.UnknownColorException;

public class Light extends GenericElectricDevice {

    public enum Color {
        White, Red, Blue, Green
    }

    Integer brightness = 5;
    Color color = Color.White;

    public Light(String deviceName, String location) {
        super(deviceName, location);
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) throws NotPossibleBrigtnessException {
        if (brightness > 0 && brightness >= 10) {
            this.brightness = brightness;
        }
        throw new NotPossibleBrigtnessException(brightness);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) throws UnknownColorException {
        try {
            this.color = Color.valueOf(Color.class, color);
        } catch (Exception e) {
            throw new UnknownColorException(color);
        }
    }

    @Override
    public String toString() {
        return "Light{" +
                "brightness=" + brightness +
                ", color=" + color +
                "} " + super.toString();
    }
}
