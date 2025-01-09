package model.clasewrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import model.Adestrador;

import java.util.List;

public class Adestradores {
    @JacksonXmlElementWrapper(localName = "adestradrores")
    @JacksonXmlProperty(localName = "adestrador")
    private List<Adestrador> adestradorList;

    @JsonProperty("adestradores")
    private List<Adestrador> adestradoresJson;

    public Adestradores(List<Adestrador> adestradorList) {
        this.adestradorList = adestradorList;
    }

    public Adestradores() {

    }


    public List<Adestrador> getAdestradorList() {
        return adestradorList;
    }

    public void setPokemons(List<Adestrador> adestradorList) {
        this.adestradorList = adestradorList;
    }

    public List<Adestrador> getAdestradoresJson() {
        return adestradoresJson;
    }
    public void setAdestradoresJson(List<Adestrador> adestradoresJson) {
        this.adestradoresJson = adestradoresJson;
    }
}

