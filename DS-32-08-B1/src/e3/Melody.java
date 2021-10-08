package e3;

public class Melody {
    public enum Notes {DO, RE, MI, FA, SOL, LA, SI}
    public enum Accidentals {NATURAL, FLAT, SHARP}
    String notas;
    String accidentales;
    String accidentalesToString;
    String time;
    String concatenacion;
    String concatenacionToString;
    String[] trozos;
    String[] trozosToString;

    public Melody () {

    }

    public void addNote(Notes note, Accidentals accidental, float time) {
        if (note == null || accidental == null || time <= 0) throw new IllegalArgumentException();
        this.time = Float.toString(time);
        this.notas = note.name();
        this.accidentales = accidental.name();

        if (accidental.name().compareTo("NATURAL") == 0) {
            this.accidentalesToString = "";
        }
        else if (accidental.name().compareTo("FLAT") == 0) {
            this.accidentalesToString = "b";
        }
        else {
            this.accidentalesToString = "#";
        }

        if (this.concatenacionToString == null) this.concatenacionToString = this.notas + this.accidentalesToString + "(" + this.time + ") ";
        else this.concatenacionToString = this.concatenacionToString + this.notas + this.accidentalesToString + "(" + this.time + ") ";

        if (this.concatenacion == null) this.concatenacion = this.notas + " " + this.accidentales + " " + this.time;
        else this.concatenacion = this.concatenacion + " " + this.notas + " " + this.accidentales + " " + this.time;

        trozos = trocearCadena(this.concatenacion); //HACEMOS UN ARRAY DE STRINGS TROCEANDO LA CADENA
    }

    String [] trocearCadena(String s) {
         return s.trim().split("\\s+");
    }

    int buscarIndice(int index) {
        int coincidencia = 0, i; //NUMERO DE VECES QUE EL TROZO ES UN FLOAT

        for (i = 3; i <= this.trozos.length; i = i + 3) {
                coincidencia++;
                if (coincidencia == index+1) {
                    return i-1;
                }
        }
        return i-3;
    }

    public Notes getNote(int index) {
        if (index >= trozos.length || index < 0) throw new IllegalArgumentException();

        int indice;
        indice = buscarIndice(index); //BUSCAMOS EL INDICE DE LA DURACION DE LA NOTA

        return Notes.valueOf(this.trozos[indice-2]); //RETORNAMOS LA NOTA, QUE ESTA 2 POSICIONES A LA IZQUIERDA
    }

    public Accidentals getAccidental(int index) {
        if (index >= trozos.length || index < 0) throw new IllegalArgumentException();

        int indice;
        indice = buscarIndice(index); //BUSCAMOS EL INDICE DE LA DURACION DE LA NOTA

        return Accidentals.valueOf(this.trozos[indice-1]); //RETORNAMOS LA ACCIDENTAL, QUE ESTA 1 POSICION A LA IZQUIERDA
    }

    public float getTime(int index) {
        if (index >= trozos.length || index < 0) throw new IllegalArgumentException();

        int indice;
        indice = buscarIndice(index); //BUSCAMOS EL INDICE DE LA DURACION DE LA NOTA

        return Float.parseFloat(this.trozos[indice]); //RETORNAMOS LA DURACION
    }

    public int size() {
        if (this.concatenacion == null) return 0;
        else {
            return buscarIndice(-1)/3;
        }
    }

    public float getDuration () {
        int indice;
        float duracion = 0;
        for (int i = 0; i < this.size(); ++i) {
            indice = buscarIndice(i);
            duracion += Float.parseFloat(this.trozos[indice]);
        }
        return duracion;
    }

    int noteCode(String trozosNota, String trozosAlt) {
        String trozosConcat = trozosNota + trozosAlt;

        if (trozosConcat.compareTo("DOSHARP") == 0 || trozosConcat.compareTo("REFLAT") == 0) return 1;
        else if (trozosConcat.compareTo("RESHARP") == 0 || trozosConcat.compareTo("MIFLAT") == 0) return 2;
        else if (trozosConcat.compareTo("MINATURAL") == 0 || trozosConcat.compareTo("FAFLAT") == 0) return 3;
        else if (trozosConcat.compareTo("MISHARP") == 0 || trozosConcat.compareTo("FANATURAL") == 0) return 4;
        else if (trozosConcat.compareTo("FASHARP") == 0 || trozosConcat.compareTo("SOLFLAT")== 0)  return 5;
        else if (trozosConcat.compareTo("SOLSHARP") == 0 || trozosConcat.compareTo("LAFLAT") == 0) return 6;
        else if (trozosConcat.compareTo("LASHARP") == 0 || trozosConcat.compareTo("SIFLAT") == 0) return 7;
        else if (trozosConcat.compareTo("SINATURAL") == 0 || trozosConcat.compareTo("DOFLAT") == 0) return 8;
        else if (trozosConcat.compareTo("SISHARP") == 0 || trozosConcat.compareTo("DONATURAL") == 0) return 9;
        else return -1;
    }

    @Override
    public boolean equals(Object o) {
        Melody melody = (Melody) o;
        if (this.trozos == null && melody.trozos == null) return true;
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        if (this.size() != (melody.size())) return false;
        if (this.getDuration() != (melody.getDuration())) return false;
        for (int i = 0; i < this.trozos.length; i = i + 3) {
            if (this.trozos[i + 2].compareTo(melody.trozos[i + 2]) != 0) { //LAS NOTAS TIENEN DISTINTA DURACION?
                return false;
            }
            if (this.trozos[i].compareTo((melody.trozos[i])) != 0 || this.trozos[i+1].compareTo((melody.trozos[i+1])) != 0) { //EL NOMBRE DE LA NOTA Y ALTERACION ES DISTINTO?
                if (noteCode(this.trozos[i], this.trozos[i+1]) == noteCode(melody.trozos[i], (melody.trozos[i+1]))) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode () {
        int result = 0, aux = 0;
        if (this.trozos == null) return -1;
        result = this.size();
        result = 31 * result + (int) this.getDuration();
        for (int i = 0; i < this.trozos.length; i = i + 3) {
            aux = result + noteCode(this.trozos[i], this.trozos[i+1]);
        }
        result = 31 * aux;

        return result;
    }

    @Override
    public String toString () {
        return this.concatenacionToString.trim();
    }
}
