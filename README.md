# My Java Project
## Steps for bulding project
### 1.Cloning the repository
git clone <repo-url>
### 2.Install IntelliJ IDEA
unpacking the file : tar -xzf ideaIC-*.tar.gz
redirection to directory where it's unpacked : cd idea-IC-*/bin
start with : ./idea.sh (before that maybe it's necessary to do : chmod +x file_name for permission rights)
### 3.Setting up Maven
mvn clean
### 4.Install Postman
sudo snap install postman
### 5.Add dependencies into pom.xml
<dependencies>
        <!-- Javalin za REST API -->
        <dependency>
            <groupId>io.javalin</groupId>
            <artifactId>javalin</artifactId>
            <version>5.6.0</version>
        </dependency>

        <!-- Java-WebSocket za WebSocket -->
        <dependency>
            <groupId>org.java-websocket</groupId>
            <artifactId>Java-WebSocket</artifactId>
            <version>1.5.3</version> <!-- ili odgovarajuća verzija -->
        </dependency>
        <!-- JSON biblioteka (npr. Gson) -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version>
        </dependency>

        <!-- Jackson za serijalizaciju/deserijalizaciju JSON-a -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version> <!-- Proveri najnoviju verziju na https://mvnrepository.com -->
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.7</version>
        </dependency>

    </dependencies>
### 6.Testing in Postman
- Build Main file 
- In Postman test POST request with: 
    - http://localhost:8081/orders
    - In Body setup option raw and type JSON 
    - example : {
    "stockName": "AAPL",
    "price": 150.25,
    "amount": 50,
    "type": "BUY"
}
Output in console : 
Order received!
- In Postman test GET request with : 
    - http://localhost:8081/orderbook/buy
    - In Body setup option none
    - output : 
    [{"price":3330.5,"amount":120.0,"type":"BUY","stockName":"AMZN"},{"price":2200.3,"amount":100.0,"type":"BUY","stockName":"AMD"},{"price":2057.19,"amount":168.0,"type":"BUY","stockName":"AAPL"},{"price":1073.91,"amount":95.0,"type":"BUY","stockName":"ATVI"},{"price":980.6,"amount":75.0,"type":"BUY","stockName":"ADBE"},{"price":937.55,"amount":77.0,"type":"BUY","stockName":"GOOGL"},{"price":820.1,"amount":55.0,"type":"BUY","stockName":"NVDA"},{"price":720.1,"amount":25.0,"type":"BUY","stockName":"TSLA"},{"price":670.6,"amount":45.0,"type":"BUY","stockName":"ADBE"},{"price":560.45,"amount":35.0,"type":"BUY","stockName":"NVDA"}]
   - http://localhost:8081/orderbook/sell
   - In Body setup option none
   - output : 
[{"price":15.45,"amount":60.0,"type":"SELL","stockName":"SNAP"},{"price":30.95,"amount":120.0,"type":"SELL","stockName":"T"},{"price":35.25,"amount":90.0,"type":"SELL","stockName":"LYFT"},{"price":40.15,"amount":80.0,"type":"SELL","stockName":"UBER"},{"price":40.15,"amount":130.0,"type":"SELL","stockName":"PFE"},{"price":40.75,"amount":210.0,"type":"SELL","stockName":"GM"},{"price":50.55,"amount":100.0,"type":"SELL","stockName":"TWTR"},{"price":50.55,"amount":250.0,"type":"SELL","stockName":"DELL"},{"price":55.05,"amount":75.0,"type":"SELL","stockName":"VZ"},{"price":60.15,"amount":180.0,"type":"SELL","stockName":"KO"}]
