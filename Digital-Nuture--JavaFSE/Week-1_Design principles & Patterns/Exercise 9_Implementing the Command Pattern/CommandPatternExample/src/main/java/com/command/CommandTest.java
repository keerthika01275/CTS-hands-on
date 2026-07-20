package com.command;

public class CommandTest {
    public static void main(String[] args) {
        // Create the remote control
        RemoteControl remote = new RemoteControl();

        // Create light objects
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create light commands
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // Set commands for different slots
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);

        System.out.println("Testing Remote Control:");
        remote.printStatus();

        // Test commands
        System.out.println("\n1. Turn on living room light:");
        remote.onButtonPressed(0);

        System.out.println("\n2. Turn on kitchen light:");
        remote.onButtonPressed(1);

        System.out.println("\n3. Turn off kitchen light:");
        remote.offButtonPressed(1);

        System.out.println("\n4. Undo last command:");
        remote.undoButtonPressed();

        System.out.println("\n5. Turn off living room light:");
        remote.offButtonPressed(0);

        // Try to undo more commands
        System.out.println("\n6. Testing multiple undo operations:");
        remote.undoButtonPressed();
        remote.undoButtonPressed();
        remote.undoButtonPressed(); // Should show "No commands to undo"
    }
}
