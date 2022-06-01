package com.metanit;

public class Main {
    interface HighConnect {
        void HighPower(); 
    }

    interface LowConnect {
        void LowPower();
    }
    static class Lowclass implements LowConnect {
        @Override
        public void LowPower() {
            System.out.println("220w ");
        }
    }

    static class Highclass implements HighConnect {
        @Override
        public void HighPower() {
            System.out.println("заряжает 380w");
        }
    }
    static class adapter implements LowConnect {
        private HighConnect charge;
        public adapter(HighConnect charge){
            this.charge = charge;
        }
        public void tt(){
            charge.HighPower();
        }
        @Override
        public void LowPower() {
            System.out.println("заряжает 220w");
        }
    }
    public static void main(String[] args) {
        Lowclass low = new Lowclass();
        Highclass hidh = new Highclass();
        adapter adap = new adapter(hidh);
        adap.LowPower();
        adap.tt();
    }
}