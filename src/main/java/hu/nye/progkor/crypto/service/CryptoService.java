package hu.nye.progkor.crypto.service;

import hu.nye.progkor.crypto.model.Crypto;

import java.util.List;

public interface CryptoService {

    List<Crypto> getAllCryptos();

    Crypto getCrypto(Long id);

    Crypto updateCrypto(Long id, Crypto cryptoChange);

    Crypto createCrypto(Crypto crypto);

    void deleteCrypto(Long id);


}
