package e3;

import java.util.ArrayList;
import java.util.List;

public class Network {
    NetworkManager NM;

    public Network() {
        NM = new TablesImplementation();
    }
    //DAR DE ALTA A UN USUARIO EN LA RED
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        NM.addUser(user, topicsOfInterest);
    }

    //DAR DE BAJA A UN USUARIO DE LA RED
    public void removeUser(String user) {
        NM.removeUser(user);
    }

    //MODIFICAR LOS TEMAS QUE INTERESAN A UN DETERMINADO USUARIO
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        NM.addInterest(user, topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        NM.removeInterest(user, topicOfInterest);
    }
    //OBTENER LOS TEMAS QUE LE INTERESAN A UN DETERMINADO USUARIO
    public void getInterestsUser(String user) {
        NM.getInterestsUser(user);
    }

    //ENCONTRAR A TODOS LOS USUARIOS INTERESADOS EN UN TEMA ESPECIFICO
    public List<String> findUsersWithTopic(TopicOfInterest topicOfInterest) {
        List <String> lista = new ArrayList<>();
        for (String i: NM.getUsers()) {
            if (NM.getInterestsUser(i).contains(topicOfInterest)) lista.add(i);
        }
        return lista;
    }

    //BUSCAR LOS TEMAS DE INTERÉS QUE TIENEN EN COMUN DOS USUARIOS
    public List<TopicOfInterest> lookForCommonTopics(String user1, String user2) {
        List <TopicOfInterest> lista = new ArrayList<>();
        for (TopicOfInterest i : NM.getInterestsUser(user2)) {
            if (NM.getInterestsUser(user1).contains(i)) {
                lista.add(i);
            }
        }
        return lista;
    }

    //OBTENER LA LISTA DE TODOS LOS TEMAS QUE INTERESAN A LOS USUARIOS DE LA RED
    public void getInterests() {
        NM.getInterests();
    }

    //VER LA INFORMACION DE TODOS LOS USUARIOS DE LA RED
    public String getUsersInfo() {
        StringBuilder usersInfo = new StringBuilder();
        String interest;
        for (String i : NM.getUsers()) {
            usersInfo.append(i).append(": ");
            for (TopicOfInterest j : NM.getInterestsUser(i)) {
                interest = j.getTopicOfInterest();
                usersInfo.append(interest).append(" ");
            }
            usersInfo.append("\n");
        }
        return usersInfo.toString();
    }

    public static void main(String[] args) {
        Network N = new Network();

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
        topicList2.add(TI3);
        topicList2.add(TI4);
        topicList3.add(TI2);
        topicList3.add(TI5);
        topicList3.add(TI6);

        N.addUser("Pepe", topicList1);
        N.addUser("Carlos", topicList2);
        N.addUser("Matias", topicList3);

        System.out.println(N.findUsersWithTopic(TI2));
    }
}
