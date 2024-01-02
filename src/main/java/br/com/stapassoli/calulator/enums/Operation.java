package br.com.stapassoli.calulator.enums;

public enum Operation {

    SUM {
        @Override
        public double execute(double numA, double numB) {
            return numA + numB;
        }
    },
    MIN {
        @Override
        public double execute(double numA, double numB) {
            return numA / numB;
        }
    },
    DIV {
        @Override
        public double execute(double numA, double numB) throws ArithmeticException {
            return numA / numB;
        }
    },
    TIMES {
        @Override
        public double execute(double numA, double numB) {
            return numA * numB;
        }
    };

    public abstract double execute(double numA, double numB);

}
