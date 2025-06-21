public class BuilderPatternExample{
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .cpu("Intel i5")
                .ram("64GB")
                .storage("1TB SSD")
                .graphics("RTX 3050")
                .build();
        gamingPC.show();

        Computer officePC = new Computer.Builder()
                .cpu("Intel i3")
                .ram("8GB")
                .storage("512GB SSD")
                .graphics("Integrated")
                .build();
        officePC.show();
    }
}

class Computer {
    private String cpu, ram, storage, graphics;

    private Computer(Builder b) {
        cpu = b.cpu;
        ram = b.ram;
        storage = b.storage;
        graphics = b.graphics;
    }

    public void show() {
        System.out.println("\nCPU: " + cpu + ", RAM: " + ram + ", Storage: " + storage +
                (graphics != null ? ", Graphics: " + graphics : ""));
    }

    static class Builder {
        private String cpu, ram, storage, graphics;

        public Builder cpu(String c) { 
            cpu = c; 
            return this;
         }
        public Builder ram(String r) {
             ram = r;
              return this;
             }
        public Builder storage(String s) {
             storage = s;
              return this;
             }
        public Builder graphics(String g) {
             graphics = g;
              return this;
             }

        public Computer build() { 
            return new Computer(this);
         }
    }
}
