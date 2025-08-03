public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        Computer devLaptop = new Computer.Builder("AMD Ryzen 7", "16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Ubuntu 22.04 LTS")
                .build();

        System.out.println("Basic: " + basicComputer);
        System.out.println("Gaming: " + gamingComputer);
        System.out.println("Dev Laptop: " + devLaptop);
    }
}
