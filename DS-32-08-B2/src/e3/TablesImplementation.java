package e3;

import java.util.ArrayList;
import java.util.List;

public class TablesImplementation implements NetworkManager {
    String [][] usersTable;
    TopicOfInterest [][] topicsTable;
    private int fila = 0; //ULTIMA FILA DE LA TABLA

    public TablesImplementation() {
        usersTable = new String[100][1];
        topicsTable = new TopicOfInterest[100][100];
    }

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if (getUsers().contains(user)) {
            throw new IllegalArgumentException("User already exists");
        }
        this.usersTable[fila][0] = user;
        int columna = 0;
        for (TopicOfInterest i: topicsOfInterest) {
            topicsTable[this.fila][columna] = i;
            columna++;
        }
        this.fila++;
    }

    public List<String> getUsers() {
        List <String> lista = new ArrayList<>();

        for (int i = 0; i < this.fila; ++i) {
            lista.add(usersTable[i][0]);
        }
        return lista;
    }

    public void removeUser(String user) {
        int i, j, k;
        if (!getUsers().contains(user)) throw new IllegalArgumentException("User not found");
        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        for (k = i; k < this.fila; ++k) {
            usersTable[k][0] = usersTable[k+1][0];
            for (j = 0; topicsTable[k][j] != null; ++j) {
                topicsTable[k][j] = topicsTable[k+1][j];
            }
        }
        this.fila--;
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        int i, j, k;
        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        if (i > this.fila) {
            throw new IllegalArgumentException("User not found");
        }
        else {
            for (j = 0; topicsTable[i][j] != null && topicsTable[i][j] != topicOfInterest; ++j);
            if (topicsTable[i][j] == null) {
                throw new IllegalArgumentException("Topic not found");
            }
            else {
                for (k = j; topicsTable[i][k] != null; ++k) {
                    topicsTable[i][k] = topicsTable[i][k+1];
                }
            }
        }
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        int i, j;
        if (getInterestsUser(user).contains(topicOfInterest)) throw new IllegalArgumentException("This user already has this topic");
        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        if (i > this.fila) {
            throw new IllegalArgumentException("User not found");
        }
        else {
            for (j = 0; topicsTable[i][j] != null || topicsTable[i][j] == topicOfInterest; ++j);
            if (topicsTable[i][j] == topicOfInterest) {
                throw new IllegalArgumentException("This user already has this topic");
            } else {
                topicsTable[i][j] = topicOfInterest;
            }
        }
    }

    public List<TopicOfInterest> getInterests() {
        int i, j;
        List <TopicOfInterest> lista = new ArrayList<>();
        for (i = 0; i < this.fila; ++i) {
            for (j = 0; topicsTable[i][j] != null; ++j) {
                if (!lista.contains(topicsTable[i][j])) lista.add(topicsTable[i][j]);
            }
        }
        return lista;
    }

    public List<TopicOfInterest> getInterestsUser(String user) {
        int i, j;
        List <TopicOfInterest> lista = new ArrayList<>();

        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        if (i > this.fila) {
            throw new IllegalArgumentException("User not found");
        }
        else {
            for (j = 0; topicsTable[i][j] != null; ++j) {
                lista.add(topicsTable[i][j]);
            }
        }
        return lista;
    }

}
