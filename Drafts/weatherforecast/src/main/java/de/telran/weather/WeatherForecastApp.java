package de.telran.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import de.telran.weather.service.InputOutputService;
import de.telran.weather.service.WeatherGateway;
import de.telran.weather.service.WeatherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WeatherForecastApp {
    private InputOutputService inputOutputService;
    private WeatherService service;

    public WeatherForecastApp(InputOutputService inputOutputService, WeatherService service) {
        this.inputOutputService = inputOutputService;
        this.service = service;
    }

    public void execute() throws Exception {
        String s = inputOutputService.readValue();
        String result = service.getWeatherByCityName(s);
        inputOutputService.print(result);
    }
    protected static final Logger log = LogManager.getLogger(WeatherForecastApp.class);

    public static void main(String[] args) throws Exception {
        log.info("Started");
        InputOutputService inputOutputService = new InputOutputService();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        WeatherGateway weatherGateway = new WeatherGateway(mapper);
        WeatherService service = new WeatherService(weatherGateway);
        WeatherForecastApp weatherForecastApp = new WeatherForecastApp(inputOutputService, service);
        weatherForecastApp.execute();
        log.info("Finished");
    }
}
