package smart_home.command;

import smart_home.smartHome.GenericElectricDevice;

public class OnCommand extends SmartHomeCommand{
    public OnCommand(GenericElectricDevice device){
        super(device);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        GenericElectricDevice smartDevice = (GenericElectricDevice) this.device;
        smartDevice.setOnOffStatus(Boolean.TRUE);
        System.out.println(smartDevice);
        System.out.println("----------------------------------------------");
    }
}
