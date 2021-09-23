package CodingTest.상반기카카2차코딩테스트_2021;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public final static int N = 5;
    public final static int TRUCK_COUNT = 5;
    public final static int CYCLE_REQUEST_MEAN = 2;

    public static void main(String[] args) throws IOException, ParseException {

            long[][] map = new long[N][N];
            long[][] check = new long[N][N];
            Truck[] trucks = new Truck[TRUCK_COUNT];
            String result = "ready";
            String auth_key = RestAPI.startAPI(1);
            while(result.equals("ready")) {
                map = RestAPI.locationsAPI(N, auth_key);

                trucks = RestAPI.trucksAPI(TRUCK_COUNT, auth_key);

                boolean b ;
                for (int time = 0; time < 10; time++) {

                    for (int t = 0 ; t<trucks.length; t++) {
                        check = new long[N][N];
                        b= trucks[t].findNotEnough(CYCLE_REQUEST_MEAN, N, map, check);
                        if (!b) trucks[t].findExceeding(CYCLE_REQUEST_MEAN, N, map, check);
                    }
//				System.out.println();
                }

                result = RestAPI.simulateAPI(trucks, auth_key);
            }
            RestAPI.scoreAPI(auth_key);

        }
        /*
        String token = initServer();
        String request = "/locations";
        createLocationApiByGet(request,"GET", token);
        JSONArray jsonArray = new JSONArray(responseObject.getJSONArray("locations"));
        for(int i = 0; i < jsonArray.length(); i++) {
            System.out.println();
        }
        */
    }

    private static String initServer() throws IOException {
        String request = "/start";
        String result = createStartApiByPost(request,"POST");
        JSONObject responseObject = new JSONObject(result);
        System.out.println(responseObject);
        return responseObject.getString("auth_key");
    }

    private static void createLocationApiByGet(String request, String method, String token) throws IOException {
        String requestURL = createURL(request);
        Map<String, String> requestHeaders = createHeader2(token);
        String result = RequestService.requestApiByGet(requestURL, requestHeaders,method);
        System.out.println("get" + result);
    }

    private static String createStartApiByPost(String request, String method) throws IOException {
        String requestURL = createURL(request);
        Map<String, String> requestHeaders = createHeaderWithInit();
        JSONObject jsonData = createBody();
        String result = RequestService.requestApiByPost(requestURL, requestHeaders, jsonData, method);
        System.out.println(result);
        return result;
    }

    private static JSONObject createBody() {
        JSONObject jsonData = new JSONObject();
        jsonData.put("problem",1);
        return jsonData;
    }

    private static String createURL(String request) {
        String apiURL = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users";
        apiURL += request;
        return apiURL;
    }

    private static Map<String, String> createHeaderWithInit() {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Auth-Token", "b139e24d5b79c17b35060ad2eff7c7cd");
        requestHeaders.put("Content-Type", "application/json");
        return requestHeaders;
    }

    private static Map<String, String> createHeader2(String token) {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", token);
        requestHeaders.put("Content-Type", "application/json");
        return requestHeaders;
    }
}
