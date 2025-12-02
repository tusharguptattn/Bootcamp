package org.example.commandPattern;

public class Main {

    public static void main(String[] args) {
        TV tv = new TV();
        Command turnOnCommand = new TurnOn(tv);
        Command turnOffCommand = new TurnOff(tv);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();


    }



}
