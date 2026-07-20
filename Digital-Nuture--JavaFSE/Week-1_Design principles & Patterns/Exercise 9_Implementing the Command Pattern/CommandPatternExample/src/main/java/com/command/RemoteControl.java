package com.command;

import java.util.Stack;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> commandHistory;
    private static final int SLOT_COUNT = 7;

    public RemoteControl() {
        onCommands = new Command[SLOT_COUNT];
        offCommands = new Command[SLOT_COUNT];
        commandHistory = new Stack<>();

        // Initialize with no command
        for (int i = 0; i < SLOT_COUNT; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
        commandHistory.push(onCommands[slot]);
    }

    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
        commandHistory.push(offCommands[slot]);
    }

    public void undoButtonPressed() {
        if (!commandHistory.isEmpty()) {
            System.out.println("\nUndo operation:");
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("\nNo commands to undo");
        }
    }

    public void printStatus() {
        System.out.println("\n------ Remote Control Status ------");
        for (int i = 0; i < SLOT_COUNT; i++) {
            System.out.println("Slot " + i + ": " +
                    onCommands[i].getName() + " | " +
                    offCommands[i].getName());
        }
        System.out.println("--------------------------------");
    }
}
