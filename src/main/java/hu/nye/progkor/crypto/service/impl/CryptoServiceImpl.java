package hu.nye.progkor.crypto.service.impl;

import hu.nye.progkor.crypto.model.Crypto;
import hu.nye.progkor.crypto.model.exception.NotFoundException;
import hu.nye.progkor.crypto.service.CryptoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final List<Crypto> DATA_BASE = new ArrayList<>();

    static{

        DATA_BASE.add(new Crypto(1L,"bitcoin","BTC",300));
        DATA_BASE.add(new Crypto(2L,"ravencoin","RVN",5));
        DATA_BASE.add(new Crypto(3L,"ethereum","ETH",20));
        DATA_BASE.add(new Crypto(4L,"ethereum classic","ETC",15));

    }


    @Override
    public List<Crypto> getAllCryptos() {
        return Collections.unmodifiableList(DATA_BASE);
    }

    @Override
    public Crypto getCrypto(Long id) {
        return DATA_BASE.stream()
                .filter(crypto -> crypto.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Crypto updateCrypto(Long id, Crypto cryptoChange) {
        final Crypto crypto = getCrypto(id);
        crypto.setName(cryptoChange.getName());
        crypto.setShortName(cryptoChange.getShortName());
        crypto.setValue(cryptoChange.getValue());
        return crypto;

    }

    @Override
    public Crypto createCrypto(Crypto crypto) {
        crypto.setId(getNextId());
        DATA_BASE.add(crypto);
        return  crypto;
    }

    @Override
    public void deleteCrypto(Long id) {
        final Crypto crypto = getCrypto(id);
        DATA_BASE.remove(crypto);

    }

    private long getNextId(){
        return getLastId() + 1L;
    }
    private long getLastId() {

        return DATA_BASE.stream()
                .mapToLong(Crypto::getId)
                .max()
                .orElse(0);

    }
}
