package it.longobucco.analisihttp.prova.controllers;

        import it.longobucco.analisihttp.prova.model.HeadersModel;
        import it.longobucco.analisihttp.prova.model.dto.HeadersModelDto;
        import it.longobucco.analisihttp.prova.services.HeadersService;
        import org.jsoup.Connection;
        import org.jsoup.HttpStatusException;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@CrossOrigin
public class HeadersController {

    @Autowired
    HeadersService headersService;

    @PostMapping
    public HeadersModel getHeaders(@RequestBody Map<String,String> methodUrl) {
        String request = "";
        String  response = "";
        Integer code = 0;
        String okMessage = "";
        String method = "";
        String err ="  ";
        List<String> headers = new ArrayList<>();
        Connection connection;

        HeadersModel model = new HeadersModel();
        if(methodUrl!= null) {
            try {
                connection= headersService.execution(methodUrl.get("url"));
                //  connection = connection.header("Content-type","application/json");
                Connection.Request req =connection.request().method(Connection.Method.valueOf(methodUrl.get("method")));
                request = req.headers().toString();
                response = connection.execute().headers().toString();
                headers =  connection.response().headers()
                        .entrySet()
                        .stream()
                        .limit(3).map(x->x.getKey()+"="+x.getValue())
                        .collect(Collectors.toList());
                okMessage = connection.response().statusMessage();
                code = connection.response().statusCode();
                method=connection.response().method().name();
            } catch (IOException e) {
               err= e.getMessage();
                model.setError(err);
                model.setValidCode(404);
                model.setUrl(methodUrl.get("url"));
                headersService.addHeadrs(model);
                return model;
            }
        }
        model = new HeadersModel(methodUrl.get("url"),code,okMessage,method,request,response ,
                headers.get(0),headers.get(1),err);
        headersService.addHeadrs(model);
        return model;
    }

    @GetMapping("/{id}")
    public HeadersModelDto getInfoById(@PathVariable Integer id) {
        HeadersModel model = headersService.findById(id);
        HeadersModelDto dto = new HeadersModelDto();
        if(model!= null){
            dto.setMethod(model.getMethod());
            dto.setStatusCode(model.getValidCode());
            dto.setOk(model.getOk());
            dto.setRespHeader1(model.getHeader1());
            dto.setRespHeader2(model.getHeader2());
            dto.setUrl(model.getUrl());
            String path = headersService.getPath(model.getUrl());
            dto.setPath(path);
            dto.setErr(model.getError());
        }
        return dto;
    }

}




