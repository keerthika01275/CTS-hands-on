package com.builder;

public class BuilderTest {
    public static void main(String[] args) {
        // Build a basic computer with only required parameters
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
                .build();
        System.out.println("Basic Computer Configuration:");
        System.out.println(basicComputer);
        System.out.println();

        // Build a gaming computer with all optional parameters
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("2TB SSD")
                .graphicsCard("NVIDIA RTX 3080")
                .powerSupply("850W Gold")
                .wifi(true)
                .bluetooth(true)
                .build();
        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComputer);
        System.out.println();

        // Build a work computer with some optional parameters
        Computer workComputer = new Computer.Builder("Intel i7", "16GB")
                .storage("1TB SSD")
                .wifi(true)
                .bluetooth(false)
                .build();
        System.out.println("Work Computer Configuration:");
        System.out.println(workComputer);
    }
}
