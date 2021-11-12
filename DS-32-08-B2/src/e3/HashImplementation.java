package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class HashImplementation implements NetworkManager {
    Map <String, List<TopicOfInterest>> map = new LinkedHashMap<>();

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        map.put(user, topicsOfInterest);
    }

    public void removeUser(String user) {
        map.remove(user);
    }

    public List<String> getUsers() {
        return new ArrayList<>(map.keySet());
    }

    public List<TopicOfInterest> getInterests() {
        List <TopicOfInterest> lista = new ArrayList<>();
        for (List<TopicOfInterest> i : map.values()) {
            for (TopicOfInterest topicOfInterest : i) {
                if (!lista.contains(topicOfInterest)) {
                    lista.add(topicOfInterest);
                }
            }
        }
        return lista;
    }

    public List<TopicOfInterest> getInterestsUser(String user) {
       return map.get(user);
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        map.get(user).add(topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        map.get(user).remove(topicOfInterest);
    }

    public static void main(String[] args) {
        HashImplementation HI = new HashImplementation();

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

        HI.addUser("Pepe", topicList1);
        HI.addUser("Carlos", topicList2);
        HI.addUser("Matias", topicList3);

        System.out.println(HI.getUsers());
        for (int i = 0; i < HI.getInterests().size(); ++i) {
           System.out.print(HI.getInterests().get(i).getTopicOfInterest() + " ");
        }
        System.out.println();

        for (int i = 0; i < HI.getInterestsUser("Carlos").size(); ++i) {
            System.out.print(HI.getInterestsUser("Carlos").get(i).getTopicOfInterest() + " ");
        }
        System.out.println();

        TopicOfInterest TI7 = new TopicOfInterest("Counter");

        HI.addInterest("Pepe", TI7);

        for (int i = 0; i < HI.getInterests().size(); ++i) {
            System.out.print(HI.getInterests().get(i).getTopicOfInterest() + " ");
        }
        System.out.println();

        for (int i = 0; i < HI.getInterestsUser("Pepe").size(); ++i) {
            System.out.print(HI.getInterestsUser("Pepe").get(i).getTopicOfInterest() + " ");
        }
        System.out.println();

        HI.removeInterest("Pepe", TI7);

        for (int i = 0; i < HI.getInterests().size(); ++i) {
            System.out.print(HI.getInterests().get(i).getTopicOfInterest() + " ");
        }
        System.out.println();

        for (int i = 0; i < HI.getInterestsUser("Pepe").size(); ++i) {
            System.out.print(HI.getInterestsUser("Pepe").get(i).getTopicOfInterest() + " ");
        }
        System.out.println();

    }


}
