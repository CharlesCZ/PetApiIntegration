package org.czekalski.petapiintegration.resourceserver.service;


import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import wiremock.com.fasterxml.jackson.databind.JsonNode;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest("messages.base-uri=http://localhost:6666/v2/animals")
@AutoConfigureWireMock(port = 6666)
class AnimalServiceIntegrationTest {

    @Autowired
    private AnimalService animalService;

    @Test
    void findDogsByCityIdAndDogsQuantity() throws IOException {
        //given
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree("{\"animals\":[{\"id\":47407036,\"organization_id\":\"NH10\",\"url\":\"https:\\/\\/www.petfinder.com\\/dog\\/coco-47407036\\/nh\\/east-derry\\/greater-derry-humane-society-inc-nh10\\/?referrer_id=d08eabd0-f16d-4f6e-ab8a-d15115929e6f\",\"type\":\"Dog\",\"species\":\"Dog\",\"breeds\":{\"primary\":\"Chihuahua\",\"secondary\":null,\"mixed\":false,\"unknown\":false},\"colors\":{\"primary\":null,\"secondary\":null,\"tertiary\":null},\"age\":\"Young\",\"gender\":\"Female\",\"size\":\"Medium\",\"coat\":null,\"attributes\":{\"spayed_neutered\":true,\"house_trained\":false,\"declawed\":null,\"special_needs\":false,\"shots_current\":false},\"environment\":{\"children\":null,\"dogs\":null,\"cats\":null},\"tags\":[],\"name\":\"Coco\",\"description\":\"All interested people should submit an adoption application as their first step.\\n\\nAll pets adopted from GDHS are spayed or...\",\"photos\":[{\"small\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/1\\/?bust=1582029634\\u0026width=100\",\"medium\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/1\\/?bust=1582029634\\u0026width=300\",\"large\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/1\\/?bust=1582029634\\u0026width=600\",\"full\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/1\\/?bust=1582029634\"},{\"small\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/3\\/?bust=1582029635\\u0026width=100\",\"medium\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/3\\/?bust=1582029635\\u0026width=300\",\"large\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/3\\/?bust=1582029635\\u0026width=600\",\"full\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/3\\/?bust=1582029635\"},{\"small\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/2\\/?bust=1582029635\\u0026width=100\",\"medium\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/2\\/?bust=1582029635\\u0026width=300\",\"large\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/2\\/?bust=1582029635\\u0026width=600\",\"full\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407036\\/2\\/?bust=1582029635\"}],\"status\":\"adoptable\",\"status_changed_at\":\"2020-02-18T12:30:30+0000\",\"published_at\":\"2020-02-18T12:30:30+0000\",\"distance\":18.0935,\"contact\":{\"email\":\"contact@derryhumanesociety.com\",\"phone\":\"(603) 434-1512\",\"address\":{\"address1\":\"P. O. Box 142\",\"address2\":null,\"city\":\"East Derry\",\"state\":\"NH\",\"postcode\":\"03041\",\"country\":\"US\"}},\"_links\":{\"self\":{\"href\":\"\\/v2\\/animals\\/47407036\"},\"type\":{\"href\":\"\\/v2\\/types\\/dog\"},\"organization\":{\"href\":\"\\/v2\\/organizations\\/nh10\"}}},{\"id\":47407012,\"organization_id\":\"TN322\",\"url\":\"https:\\/\\/www.petfinder.com\\/dog\\/friar-dot-dot-awesome-pup-47407012\\/vt\\/guilford\\/paws-of-dale-hollow-tn322\\/?referrer_id=d08eabd0-f16d-4f6e-ab8a-d15115929e6f\",\"type\":\"Dog\",\"species\":\"Dog\",\"breeds\":{\"primary\":\"Border Collie\",\"secondary\":\"Australian Shepherd\",\"mixed\":true,\"unknown\":false},\"colors\":{\"primary\":\"Tricolor (Brown, Black, \\u0026 White)\",\"secondary\":null,\"tertiary\":null},\"age\":\"Baby\",\"gender\":\"Male\",\"size\":\"Medium\",\"coat\":\"Medium\",\"attributes\":{\"spayed_neutered\":false,\"house_trained\":false,\"declawed\":null,\"special_needs\":false,\"shots_current\":true},\"environment\":{\"children\":true,\"dogs\":true,\"cats\":true},\"tags\":[],\"name\":\"FRIAR....AWESOME PUP\",\"description\":\"MEET ALBEE.....ALBEE and his siblings were in a terrible living situation...open  outside pen on dirt , no shelter ..food and...\",\"photos\":[{\"small\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/3\\/?bust=1582027443\\u0026width=100\",\"medium\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/3\\/?bust=1582027443\\u0026width=300\",\"large\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/3\\/?bust=1582027443\\u0026width=600\",\"full\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/3\\/?bust=1582027443\"},{\"small\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/1\\/?bust=1582027333\\u0026width=100\",\"medium\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/1\\/?bust=1582027333\\u0026width=300\",\"large\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/1\\/?bust=1582027333\\u0026width=600\",\"full\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/1\\/?bust=1582027333\"},{\"small\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/2\\/?bust=1582027351\\u0026width=100\",\"medium\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/2\\/?bust=1582027351\\u0026width=300\",\"large\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/2\\/?bust=1582027351\\u0026width=600\",\"full\":\"https:\\/\\/dl5zpyw5k3jeb.cloudfront.net\\/photos\\/pets\\/47407012\\/2\\/?bust=1582027351\"}],\"status\":\"adoptable\",\"status_changed_at\":\"2020-02-18T12:04:17+0000\",\"published_at\":\"2020-02-18T12:04:17+0000\",\"distance\":74.2352,\"contact\":{\"email\":\"pawsofdalehollow@gmail.com\",\"phone\":\"931-864-8550\",\"address\":{\"address1\":null,\"address2\":null,\"city\":\"Guilford\",\"state\":\"VT\",\"postcode\":\"05301\",\"country\":\"US\"}},\"_links\":{\"self\":{\"href\":\"\\/v2\\/animals\\/47407012\"},\"type\":{\"href\":\"\\/v2\\/types\\/dog\"},\"organization\":{\"href\":\"\\/v2\\/organizations\\/tn322\"}}}],\"pagination\":{\"count_per_page\":2,\"total_count\":186314,\"current_page\":1,\"total_pages\":93157,\"_links\":{\"next\":{\"href\":\"\\/v2\\/animals?limit=2\\u0026location=Andover,%20MA\\u0026page=2\\u0026type=dog\"}}}}");
        stubFor(get(urlEqualTo("/v2/animals?location=Andover,%20MA&limit=2&page=1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withJsonBody(actualObj)));

        //when
        AnimalResourcesListDto returnedAnimalResourcesListDto = animalService.findDogsByCityIdAndStateId("MA", "Andover", 2, 1);

        //then
        assertEquals(returnedAnimalResourcesListDto.getPagination().getTotalElements(), 186314L);
        assertEquals(returnedAnimalResourcesListDto.getPagination().getPageable().getPageSize(), 2);
        assertThat(returnedAnimalResourcesListDto.getPagination().getContent()).hasSize(2);
    }
}