import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

//    private final static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/dollar_info?json"; доллар
//    private final static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"; все
    //String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&date=20200302"; //варіативна ссилка
    
    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner money = new Scanner(System.in);
        System.out.println("enter the currency (available is GBP, RUB)");
        String currency = money.nextLine();
        switch (currency){

            case "GBP" :
                 String urlGBP = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=GBP&date=20200302";
                HttpClient client = HttpClient
                        .newBuilder()
                        .build();
                HttpRequest request = HttpRequest.newBuilder()
                        .header("Accept", "application/json")
                        .GET()
                        .uri(URI.create(urlGBP))
                        .build();

                var response =
                        client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                break;

            case "RUB" :

                String urlRUB = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=RUB&date=20200302";
                HttpClient clientRUB = HttpClient
                        .newBuilder()
                        .build();
                HttpRequest requestRUB = HttpRequest.newBuilder()
                        .header("Accept", "application/json")
                        .GET()
                        .uri(URI.create(urlRUB))
                        .build();

                var responseRUB =
                        clientRUB.send(requestRUB, HttpResponse.BodyHandlers.ofString());
                System.out.println(responseRUB.body());
                break;


        }

    }


}
