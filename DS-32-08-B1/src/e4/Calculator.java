package e4;

import java.util.ArrayList;

public class Calculator {
    public ArrayList <Float> l;
    public float resultado = 0;
    public String toStringConcatenation;
    public int lastIndice = 1;
    private boolean isFirstOperationAdd;


    enum operators {
        SUMAR('+'),
        RESTAR('-'),
        MULTIPLICAR('*'),
        DIVIDIR('/');

        private int valor;

        public int getValor() {
            return valor;
        }

        operators(int valor) {
            this.valor = valor;
        }
    }

    public Calculator () {
        l = new ArrayList<>();
        isFirstOperationAdd = true;

    }

    public void cleanOperations () {
        this.l.clear();
        isFirstOperationAdd = true;
    }

    public void addOperation(String operation, float ... values) {
        if (this.isFirstOperationAdd) {
            this.l.add(values[0]);
            if (operation.compareTo(String.valueOf(Character.toChars(operators.SUMAR.getValor()))) == 0) {
                this.l.add((float) operators.SUMAR.getValor());
            }
            else if (operation.compareTo(String.valueOf(Character.toChars(operators.RESTAR.getValor()))) == 0) {
                this.l.add((float) operators.RESTAR.getValor());
            }
            else if (operation.compareTo(String.valueOf(Character.toChars(operators.DIVIDIR.getValor()))) == 0){
                this.l.add((float) operators.DIVIDIR.getValor());
            }
            else if (operation.compareTo(String.valueOf(Character.toChars(operators.MULTIPLICAR.getValor()))) == 0) {
                this.l.add((float) operators.MULTIPLICAR.getValor());
            }
            else {
                this.cleanOperations();
                throw new IllegalArgumentException();
            }
            this.l.add(values[1]);

            this.isFirstOperationAdd = false;
        }
        else {
            if (operation.compareTo(String.valueOf(Character.toChars(operators.SUMAR.getValor()))) == 0) {
                this.l.add((float) operators.SUMAR.getValor());
            }
            else if (operation.compareTo(String.valueOf(Character.toChars(operators.RESTAR.getValor()))) == 0) {
                this.l.add((float) operators.RESTAR.getValor());
            }
            else if (operation.compareTo(String.valueOf(Character.toChars(operators.DIVIDIR.getValor()))) == 0){
                this.l.add((float) operators.DIVIDIR.getValor());
            }
            else if (operation.compareTo(String.valueOf(Character.toChars(operators.MULTIPLICAR.getValor()))) == 0) {
                this.l.add((float) operators.MULTIPLICAR.getValor());
            }
            else {
                this.cleanOperations();
                throw new IllegalArgumentException();
            }
            this.l.add(values[0]);


        }
    }

    public float executeOperations () {
        float resultadoCopy = 0;
        System.out.println(this.l);
        if (this.l.get(1) == '+') {
            resultado = this.l.get(0) + this.l.get(2);
        }
        else if (this.l.get(1) == '-') {
            resultado = this.l.get(0) - this.l.get(2);
        }
        else if (this.l.get(1) == '*') {
            resultado = this.l.get(0) * this.l.get(2);
        }
        else {
            if (this.l.get(2) == 0) {
                this.cleanOperations();
                resultado = 0;
                System.out.println(this.l);
                throw new ArithmeticException();
            }
            else {
                resultado = this.l.get(0) / this.l.get(2);
            }
        }

        for (int i = 3; i < this.l.size(); i = i + 2) {
            if (this.l.get(i) == '+') {
                resultado = resultado + this.l.get(i+1);
            }
            else if (this.l.get(i) == '-') {
                resultado = resultado - this.l.get(i+1);
            }
            else if (this.l.get(i) == '*') {
                resultado = resultado * this.l.get(i+1);
            }
            else {
                if (this.l.get(i+1) == 0) {
                    this.cleanOperations();
                    resultado = 0;
                    System.out.println(this.l);
                    throw new ArithmeticException();
                }
                else {
                    resultado = resultado / this.l.get(i+1);
                }

            }
        }

        this.cleanOperations();
        //System.out.println(this.l);
        resultadoCopy = resultado;
        resultado = 0;
        return resultadoCopy;

    }

    @Override
    public String toString () {
        System.out.println(this.l);

        if (this.l.size() == 0) return "[STATE:]";

        if (this.l.get(1) == '+') {
            toStringConcatenation = "[" + "STATE:[+]" + this.l.get(0) + "_" + this.l.get(2);
        }
        else if (this.l.get(1) == '-') {
            toStringConcatenation = "[" + "STATE:[-]" + this.l.get(0) + "_" + this.l.get(2);
        }
        else if (this.l.get(1) == '*') {
            toStringConcatenation = "[" + "STATE:[*]" + this.l.get(0) + "_" + this.l.get(2);
        }
        else {
            toStringConcatenation = "[" + "STATE:[/]" + this.l.get(0) + "_" + this.l.get(2);
        }

        for (int i = 3; i < this.l.size(); i = i + 2) {
            if (this.l.get(i) == '+') {
                toStringConcatenation = toStringConcatenation + "[+]" + this.l.get(i+1);
            }
            else if (this.l.get(i) == '-') {
                toStringConcatenation = toStringConcatenation + "[-]" + this.l.get(i+1);
            }
            else if (this.l.get(i) == '*') {
                toStringConcatenation = toStringConcatenation + "[*]" + this.l.get(i+1);
            }
            else {
                toStringConcatenation = toStringConcatenation + "[/]" + this.l.get(i+1);
            }
        }

        return toStringConcatenation + "]";

    }
}


