package e3;

import org.junit.jupiter.api.Test;

import javax.management.MBeanAttributeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NetworkTest {
    //INICIAL
    String usersInfo1 = """
            Pepe: Viajes Videojuegos
            Carlos: Surf Paracaidismo
            Matias: Videojuegos Musica Anime""";
    //REMOVE CARLOS

    String usersInfo2 = """
            Pepe: Viajes Videojuegos
            Carlos: Surf Paracaidismo""";

    //ADD CARLOS
    String usersInfo3 = """ 
            Pepe: Viajes Videojuegos
            Carlos: Surf Paracaidismo
            Matias: Videojuegos Musica Anime""";

    //ADD INTEREST MUSICA A PEPE, VIAJES A MATIAS Y A CARLOS
    String usersInfo4 = """ 
            Pepe: Viajes Videojuegos Musica
            Carlos: Surf Paracaidismo Viajes
            Matias: Videojuegos Musica Anime Viajes""";

    List<String> usersWithTopic = Arrays.asList("Pepe", "Carlos", "Matias");



    @Test
    public void test() {
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
        TopicOfInterest TI7 = new TopicOfInterest("Peliculas");

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
        assertThrows(IllegalArgumentException.class, () -> N.addUser("Pepe", topicList2));
        assertEquals(usersInfo1, N.getUsersInfo());

        N.removeUser("Matias");
        assertThrows(IllegalArgumentException.class, () -> N.removeUser("Matias"));
        assertEquals(usersInfo2, N.getUsersInfo());

        N.addUser("Matias", topicList3);
        assertEquals(usersInfo1, N.getUsersInfo());

        N.addInterest("Pepe", TI5);
        N.addInterest("Matias", TI1);
        N.addInterest("Carlos", TI1);
        assertThrows(IllegalArgumentException.class, () -> N.addInterest("Carlos", TI1));
        assertEquals(usersInfo4, N.getUsersInfo());

        assertEquals(usersWithTopic, N.findUsersWithTopic(TI1));
        //assertEquals(usersWithTopic2, N.findUsersWithTopic(TI7));

        assertEquals("Viajes" ,N.lookForCommonTopics("Carlos", "Matias").get(0).getTopicOfInterest());

        N.removeInterest("Carlos", TI1);
        N.removeInterest("Matias", TI1);
        N.removeInterest("Pepe", TI5);
        assertThrows(IllegalArgumentException.class, () -> N.removeInterest("Carlos", TI1));
        assertEquals(usersInfo3, N.getUsersInfo());

        assertEquals("Surf", N.getInterestsUser("Carlos").get(0).getTopicOfInterest());
        assertEquals("Paracaidismo", N.getInterestsUser("Carlos").get(1).getTopicOfInterest());

        assertEquals("Viajes", N.getInterests().get(0).getTopicOfInterest());
        assertEquals("Videojuegos", N.getInterests().get(1).getTopicOfInterest());
        assertEquals("Surf", N.getInterests().get(2).getTopicOfInterest());
        assertEquals("Paracaidismo", N.getInterests().get(3).getTopicOfInterest());
        assertEquals("Musica", N.getInterests().get(4).getTopicOfInterest());

    }

}