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
        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        if (i > this.fila) {
            System.out.println("Usuario no encotrado");
        }
        else {
            for (k = i; k < this.fila; ++k) {
                usersTable[k][0] = usersTable[k+1][0];
                for (j = 0; topicsTable[k][j] != null; ++j) {
                    topicsTable[k][j] = topicsTable[k+1][j];
                }
            }
            this.fila--;
        }
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        int i, j, k;
        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        if (i > this.fila) {
            System.out.println("Usuario no encotrado");
        }
        else {
            for (j = 0; topicsTable[i][j] != null && topicsTable[i][j] != topicOfInterest; ++j);
            if (topicsTable[i][j] == null) {
                System.out.println("Este usuario no tiene tal topico");
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
        for (i = 0; i <= this.fila && usersTable[i][0].compareTo(user) != 0; ++i);
        if (i > this.fila) {
            System.out.println("Usuario no encotrado");
        }
        else {
            for (j = 0; topicsTable[i][j] != null; ++j);
            topicsTable[i][j] = topicOfInterest;
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
            System.out.println("Usuario no encotrado");
        }
        else {
            for (j = 0; topicsTable[i][j] != null; ++j) {
                lista.add(topicsTable[i][j]);
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        List <TopicOfInterest> topicList1 = new ArrayList<>();
        List <TopicOfInterest> topicList2 = new ArrayList<>();
        List <TopicOfInterest> topicList3 = new ArrayList<>();

        TopicOfInterest TI1 = new TopicOfInterest("Viajes");
        TopicOfInterest TI2 = new TopicOfInterest("Videojuegos");
        TopicOfInterest TI3 = new TopicOfInterest("Surf");
        TopicOfInterest TI4 = new TopicOfInterest("Paracaidismo");
        TopicOfInterest TI5 = new TopicOfInterest("Musica");
        TopicOfInterest TI6 = new TopicOfInterest("Anime");

        topicList1.add(TI1);
        topicList1.add(TI2);
        System.out.println(topicList1.get(0).getTopicOfInterest());
        topicList2.add(TI3);
        topicList2.add(TI4);
        topicList3.add(TI5);
        topicList3.add(TI6);

        TablesImplementation TablesImp = new TablesImplementation();

        TablesImp.addUser("Pepe", topicList1);
        TablesImp.addUser("Carlos", topicList2);
        TablesImp.addUser("Matias", topicList3);

        System.out.println(TablesImp.getUsers());
        for (int i = 0; i < TablesImp.getInterests().size(); ++i) {
            System.out.print(TablesImp.getInterests().get(i).getTopicOfInterest() + " ");

        }
        System.out.println("");




        /*TablesImp.removeUser("Matias");
        System.out.println(TablesImp.getUsers());
        for (int i = 0; i < TablesImp.getInterests().size(); ++i) {
            System.out.print(TablesImp.getInterests().get(i).getTopicOfInterest() + " ");

        }
        System.out.println("");


        TablesImp.removeUser("Carlos");
        System.out.println(TablesImp.getUsers());
        for (int i = 0; i < TablesImp.getInterests().size(); ++i) {
            System.out.print(TablesImp.getInterests().get(i).getTopicOfInterest() + " ");

        }
        System.out.println("");*/

        /*TablesImp.removeInterest("Matias", TI6);
        System.out.println(TablesImp.getUsers());
        for (int i = 0; i < TablesImp.getInterests().size(); ++i) {
            System.out.print(TablesImp.getInterests().get(i).getTopicOfInterest() + " ");

        }
        System.out.println("");*/

        TopicOfInterest TI7 = new TopicOfInterest("Comer");
        TablesImp.addInterest("Pepe", TI7);
        System.out.println(TablesImp.getUsers());
        for (int i = 0; i < TablesImp.getInterests().size(); ++i) {
            System.out.print(TablesImp.getInterests().get(i).getTopicOfInterest() + " ");

        }
        System.out.println("");

        for (int i = 0; i < TablesImp.getInterestsUser("Carlos").size(); ++i) {
            System.out.print(TablesImp.getInterestsUser("Carlos").get(i).getTopicOfInterest() + " ");
        }
        System.out.println("");

        for (int i = 0; i < TablesImp.getInterestsUser("Pepe").size(); ++i) {
            System.out.print(TablesImp.getInterestsUser("Pepe").get(i).getTopicOfInterest() + " ");
        }
        System.out.println("");
    }
}
