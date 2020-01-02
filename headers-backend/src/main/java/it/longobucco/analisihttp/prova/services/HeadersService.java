package it.longobucco.analisihttp.prova.services;

import it.longobucco.analisihttp.prova.model.HeadersModel;
import it.longobucco.analisihttp.prova.repo.HeadersRepository;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HeadersService {



  public List<HeadersModel> getAll();
  public void addHeadrs(HeadersModel m);
  public Connection execution(String url) throws HttpStatusException;
  public HeadersModel findById(Integer id);
  public String getPath(String url);


}
