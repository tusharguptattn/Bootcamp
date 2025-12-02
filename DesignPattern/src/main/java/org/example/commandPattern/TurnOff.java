package org.example.commandPattern;

public class TurnOff implements Command{

    private Device device;

    public TurnOff(Device d){
        device=d;
    }


    @Override
    public void execute() {
        device.turnOff();
    }
}
