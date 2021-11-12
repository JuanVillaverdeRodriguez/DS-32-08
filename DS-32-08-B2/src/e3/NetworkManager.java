package e3;

import java.util.List;

public interface NetworkManager {
    //AÑADIR USUARIO A LA RED
    void addUser(String user, List<TopicOfInterest> topicsOfInterest);

    //ELIMINAR USUARIO DE LA RED
    void removeUser(String user);

    //AÑADIR UN TEMA DE INTERES A UN USUARIO DE LA RED
    void addInterest(String user, TopicOfInterest topicOfInterest);

    //ELIMINAR UN TEMA DE INTERES A UN USUARIO DE LA RED
    void removeInterest(String user, TopicOfInterest topicOfInterest);

    //DEVOLVER LA LISTA DE USUARIOS REGISTRADOS
    List<String> getUsers();

    //DEVOLVER LA LISTA DE LOS TEMAS QUE INTERESAN A LOS USUARIOS DE LA RED
    List<TopicOfInterest> getInterests();

    //DEVOLVER LOS TEMAS DE INTERES PARA UN USUARIO DADO
    List<TopicOfInterest> getInterestsUser(String user);
}
