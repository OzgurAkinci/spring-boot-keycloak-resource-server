package com.app.springbootkeycloakresourceserver.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    /*@Autowired
    private KeycloakRestTemplate keycloakRestTemplate;*/

    /*public void getCurrentUser() {
        //Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
        Keycloak kc = getAdminKeycloakUser();

        printAccessToken(kc);
        String useNname = "user1";
    }

    public Keycloak getAdminKeycloakUser() {
        return KeycloakBuilder.builder() //
                .serverUrl("http://localhost:8100/auth")
                .realm("test")
                .grantType(OAuth2Constants.PASSWORD)
                .clientId("newClient") //
                //.clientSecret("clientSecret")
                .username("john@test.com")
                .password("123")
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build())
                .build();
    }

    private static void printAccessToken(Keycloak kc) {
        try {
            String accessTokenString = kc.tokenManager().getAccessToken().getToken();
            System.out.println("accessTokenString: " + accessTokenString);
            JWSInput input = new JWSInput(accessTokenString);
            AccessToken accessToken = input.readJsonContent(AccessToken.class);
            System.out.println("subject: " + accessToken.getSubject());
            System.out.println("preferredUsername: " + accessToken.getPreferredUsername());
            System.out.println("givenName: " + accessToken.getGivenName());
        } catch (ClientErrorException e) {
            handleClientErrorException(e);
        } catch (JWSInputException e) {
            e.printStackTrace();
        }
    }*/



    /*private static void handleClientErrorException(ClientErrorException e) {
        e.printStackTrace();
        Response response = e.getResponse();
        try {
            System.out.println("status: " + response.getStatus());
            System.out.println("reason: " + response.getStatusInfo().getReasonPhrase());
            Map error = JsonSerialization.readValue((ByteArrayInputStream) response.getEntity(), Map.class);
            System.out.println("error: " + error.get("error"));
            System.out.println("error_description: " + error.get("error_description"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
