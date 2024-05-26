package kea.exercises.xpbowlingbackendkyll.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ReplacementOrderServiceTest {

    @Autowired
    private WebTestClient webTestClient;



@Test
void createReplacementOrderCheckID() {
    webTestClient.post().uri("/replacementorders").contentType(MediaType.APPLICATION_JSON)
            .bodyValue("""
                        
{
    "replacementOrder": {
            "title": "test title",
            "totalPrice": 200.0,
            "timeDate": "2024-05-19T19:56:51.015"
         },
    "orderItems": [
        {
            "amountToOrder": 6,
            "stockItem": {"name": "Bowling-shoe-pair size 38"}
        }

    ]

}

    """)
            .exchange()
            .expectStatus().isCreated()
            .expectBody(String.class)
            .consumeWith(response -> {
                String responseBody = response.getResponseBody();
                assertNotNull(responseBody);
                assertTrue(responseBody.contains("id"));
                System.out.println(responseBody);
            });
}



//    @Test
//    void createReplacementOrder() {
//        webTestClient.post().uri("/replacementorders").contentType(MediaType.APPLICATION_JSON)
//                .bodyValue("""
//
//                        {
//    "replacementOrder": {
//            "title": "test title",
//            "totalPrice": 200.0,
//            "timeDate": "2024-05-19T19:56:51.015"
//         },
//    "orderItems": [
//        {
//            "amountToOrder": 6,
//            "stockItem": {"name": "Bowling-shoe-pair size 38"}
//        }
//
//    ]
//
//}
//
//        """)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody(String.class)
//                .consumeWith(response -> System.out.println(response.getResponseBody()));
//    }


}