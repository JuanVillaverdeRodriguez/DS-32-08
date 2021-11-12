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
    public List<TopicOfInterest> getInterestsUser(String user) {
        return NM.getInterestsUser(user);
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
    public List<TopicOfInterest> getInterests() {
        return NM.getInterests();
    }

    //VER LA INFORMACION DE TODOS LOS USUARIOS DE LA RED
    public String getUsersInfo() {
        StringBuilder usersInfo = new StringBuilder();
        String interest;
        for (String i : NM.getUsers()) {
            usersInfo.append(i).append(":");
            for (TopicOfInterest j : NM.getInterestsUser(i)) {
                usersInfo.append(" ");
                interest = j.getTopicOfInterest();
                usersInfo.append(interest);
            }
            usersInfo.append("\n");
        }
        return usersInfo.toString().trim();
    }
}
