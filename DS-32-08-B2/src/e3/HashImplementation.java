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
        if (map.get(user).contains(topicOfInterest)) throw new IllegalArgumentException("This user already has such topic");
        else map.get(user).add(topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if (!map.get(user).contains(topicOfInterest)) throw new IllegalArgumentException("This user doesnt has such topic");
        else map.get(user).remove(topicOfInterest);
    }
}
