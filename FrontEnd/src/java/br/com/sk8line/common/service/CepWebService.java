/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.common.service;

import br.com.sk8line.common.ejb.EstadoRemote;
import br.com.sk8line.common.model.Endereco;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Consulta WebService do República Virtual para obter o endereço
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@ManagedBean
public class CepWebService {

    private final Endereco endereco = new Endereco();

    private EstadoRemote ejbEstado;

    public CepWebService(EstadoRemote ejbEstado) {
        this.ejbEstado = ejbEstado;
    }

    public Endereco getEnderecoByCep(String cep) {

        URL url;
        try {
            url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream conteudo = conn.getInputStream();

            JsonReader reader = Json.createReader(conteudo);
            JsonObject obj = reader.readObject();

            if (obj.getInt("resultado") != 0) {
                this.endereco.setLogradouro(obj.getString("tipo_logradouro") + " " + obj.getString("logradouro"));
                this.endereco.setBairro(obj.getString("bairro"));
                this.endereco.setCidade(obj.getString("cidade"));

                this.endereco.setEstado(ejbEstado.getByUf(obj.getString("uf")));
                this.endereco.setCep(cep);

                return this.endereco;
            } else {
                return null;
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(CepWebService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CepWebService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
