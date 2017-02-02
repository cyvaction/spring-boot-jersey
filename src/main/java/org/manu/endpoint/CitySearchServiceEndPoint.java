package org.manu.endpoint;

import org.manu.domain.City;
import org.manu.dto.CityDTO;
import org.manu.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/search/city")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class CitySearchServiceEndPoint {
    private ModelMapper modelMapper = new ModelMapper();
    private final CityService cityService;

    public CitySearchServiceEndPoint(CityService cityService) {
        this.cityService = cityService;
    }

    @GET
    public CityDTO getCity(@QueryParam("name") @NotNull String cityName) {
        City city = cityService.getCity(cityName);
        CityDTO cityDTO = modelMapper.map(city, CityDTO.class);
        return cityDTO;
    }
}
