package it.longobucco.analisihttp.prova.services;

import it.longobucco.analisihttp.prova.model.HeadersModel;
import it.longobucco.analisihttp.prova.repo.HeadersRepository;
import org.jsoup.helper.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.*;
import org.springframework.web.client.RestTemplate;

@Service
public class HeadersServiceImpl implements HeadersService{

  @Autowired
  HeadersRepository headersRepository;

  @Override
  public List<HeadersModel> getAll() {
    return headersRepository.findAll();
  }



  @Override
  public void addHeadrs(HeadersModel m) {
     headersRepository.save(m);
  }

  @Override
  public Connection execution(String url) throws HttpStatusException {
    Connection connection= null;
    if(url.startsWith("http"))
      connection = Jsoup.connect(url);
    else{
      throw new HttpStatusException("pagina non trovata",404,url);
    }
    if(connection== null)throw new HttpStatusException("pagina non trovata",404,url);

      return connection;
  }

  @Override
  public HeadersModel findById(Integer id) {
    return headersRepository.findById(id).orElse(null);
  }

  @Override
  public String getPath(String url){
    String[] arrPath = new String[4];
    String[] arrPath1 = url.split("/",4);
    for (int i = 0; i < arrPath1.length; i++) {
      arrPath[i]= arrPath1[i];
    }
    String path = arrPath[3];
    return path;
  }
}
